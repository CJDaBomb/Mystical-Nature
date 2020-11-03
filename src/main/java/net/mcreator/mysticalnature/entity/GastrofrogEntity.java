
package net.mcreator.mysticalnature.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.mysticalnature.MysticalNatureModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MysticalNatureModElements.ModElement.Tag
public class GastrofrogEntity extends MysticalNatureModElements.ModElement {
	public static EntityType entity = null;
	public GastrofrogEntity(MysticalNatureModElements instance) {
		super(instance, 27);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(1f, 1.9f))
						.build("gastrofrog").setRegistryName("gastrofrog");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -13421773, -6697984, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("gastrofrog"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mystical_nature:acid_barrens")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 1, 3));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelAcidToad(), 1f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("mystical_nature:textures/acidtoad2.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			this.moveController = new MovementController(this) {
				@Override
				public void tick() {
					if (CustomEntity.this.areEyesInFluid(FluidTags.WATER))
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, 0.005, 0));
					if (this.action == MovementController.Action.MOVE_TO && !CustomEntity.this.getNavigator().noPath()) {
						double dx = this.posX - CustomEntity.this.getPosX();
						double dy = this.posY - CustomEntity.this.getPosY();
						double dz = this.posZ - CustomEntity.this.getPosZ();
						dy = dy / (double) MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
						CustomEntity.this.rotationYaw = this.limitAngle(CustomEntity.this.rotationYaw,
								(float) (MathHelper.atan2(dz, dx) * (double) (180 / (float) Math.PI)) - 90, 90);
						CustomEntity.this.renderYawOffset = CustomEntity.this.rotationYaw;
						CustomEntity.this.setAIMoveSpeed(MathHelper.lerp(0.125f, CustomEntity.this.getAIMoveSpeed(),
								(float) (this.speed * CustomEntity.this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue())));
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, CustomEntity.this.getAIMoveSpeed() * dy * 0.1, 0));
					} else {
						CustomEntity.this.setAIMoveSpeed(0);
					}
				}
			};
			this.navigator = new SwimmerPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1, 40));
			this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this, VoxelShapes.create(this.getBoundingBox()));
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}
	}

	// Made with Blockbench 3.7.1
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelAcidToad extends EntityModel<Entity> {
		private final ModelRenderer BODY;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer LLeg;
		private final ModelRenderer RLeg;
		private final ModelRenderer FrontLLeg;
		private final ModelRenderer FrontRLeg;
		public ModelAcidToad() {
			textureWidth = 128;
			textureHeight = 128;
			BODY = new ModelRenderer(this);
			BODY.setRotationPoint(0.0F, 24.0F, 0.0F);
			BODY.setTextureOffset(0, 0).addBox(-10.0F, -20.0F, -7.0F, 20.0F, 16.0F, 17.0F, 0.0F, false);
			BODY.setTextureOffset(59, 18).addBox(-9.5F, -27.0F, -20.0F, 19.0F, 8.0F, 15.0F, 0.0F, false);
			BODY.setTextureOffset(0, 33).addBox(-10.5F, -19.0F, -21.0F, 21.0F, 6.0F, 16.0F, 0.0F, false);
			BODY.setTextureOffset(0, 33).addBox(-11.5F, -23.0F, -14.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);
			BODY.setTextureOffset(89, 74).addBox(-11.5F, -24.0F, -8.0F, 3.0F, 5.0F, 5.0F, 0.0F, false);
			BODY.setTextureOffset(0, 0).addBox(9.0F, -23.0F, -14.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);
			BODY.setTextureOffset(89, 74).addBox(8.0F, -24.0F, -8.0F, 3.0F, 5.0F, 5.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -19.9919F, 2.1572F);
			BODY.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.4363F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(58, 41).addBox(-9.0F, -3.0F, -9.5F, 18.0F, 6.0F, 16.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -12.3749F, -7.2603F);
			BODY.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.8727F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(0, 55).addBox(-9.5F, -9.5F, -7.0F, 19.0F, 15.0F, 13.0F, 0.0F, false);
			LLeg = new ModelRenderer(this);
			LLeg.setRotationPoint(-7.0F, 15.0F, 7.0F);
			LLeg.setTextureOffset(55, 79).addBox(-3.5F, 6.0F, -7.0F, 7.0F, 3.0F, 9.0F, 0.0F, false);
			LLeg.setTextureOffset(64, 64).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 8.0F, 7.0F, 0.0F, false);
			RLeg = new ModelRenderer(this);
			RLeg.setRotationPoint(8.0F, 14.0F, 7.0F);
			RLeg.setTextureOffset(64, 64).addBox(-5.0F, 0.0F, -3.0F, 8.0F, 8.0F, 7.0F, 0.0F, false);
			RLeg.setTextureOffset(55, 79).addBox(-4.5F, 7.0F, -7.0F, 7.0F, 3.0F, 9.0F, 0.0F, false);
			FrontLLeg = new ModelRenderer(this);
			FrontLLeg.setRotationPoint(8.0F, 15.0F, -5.0F);
			FrontLLeg.setTextureOffset(0, 83).addBox(-19.0F, -1.0F, -3.0F, 7.0F, 10.0F, 6.0F, 0.0F, false);
			FrontRLeg = new ModelRenderer(this);
			FrontRLeg.setRotationPoint(-8.0F, 14.0F, -5.0F);
			FrontRLeg.setTextureOffset(0, 83).addBox(12.0F, 0.0F, -3.0F, 7.0F, 10.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			BODY.render(matrixStack, buffer, packedLight, packedOverlay);
			LLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			RLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			FrontLLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			FrontRLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.FrontLLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.FrontRLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
