
package net.mcreator.mysticalnature.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
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
public class AcidophilixEntity extends MysticalNatureModElements.ModElement {
	public static EntityType entity = null;
	public AcidophilixEntity(MysticalNatureModElements instance) {
		super(instance, 36);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.6f, 1.8f))
						.build("acidophilix").setRegistryName("acidophilix");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -6697984, -13421773, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("acidophilix"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mystical_nature:acid_barrens")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 1, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
		DungeonHooks.addDungeonMob(entity, 180);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelAcidophilix(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("mystical_nature:textures/acidophilix.png");
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
			experienceValue = 5;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEAD;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
					.getValue(new ResourceLocation("mystical_nature:acidophilixidlesound"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
					.getValue(new ResourceLocation("mystical_nature:acidophilixhurtsound"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
					.getValue(new ResourceLocation("mystical_nature:acidophilixdeathsound"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6);
		}
	}

	// Made with Blockbench 3.7.1
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelAcidophilix extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer left_arm;
		private final ModelRenderer right_arm;
		private final ModelRenderer left_leg;
		private final ModelRenderer right_leg;
		public ModelAcidophilix() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 1.0F, -4.0F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -6.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-3.0F, 1.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(0.0F, 1.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-1.0F, 1.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(2.0F, 1.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(8, 53).addBox(0.5F, -7.5F, -6.5F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			head.setTextureOffset(10, 48).addBox(-4.5F, -5.5F, -1.5F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-1.0F, 2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(16, 50).addBox(-1.5F, -6.5F, 0.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(13, 50).addBox(2.6F, -4.5F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 7.0F, -2.0F);
			setRotationAngle(body, 0.3491F, 0.0F, 0.0F);
			body.setTextureOffset(16, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(15, 46).addBox(-3.0F, -4.342F, -2.9397F, 3.0F, 3.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(15, 47).addBox(-2.0F, 1.0405F, -2.7704F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(6, 54).addBox(-1.0F, -2.4626F, -3.6237F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(9, 48).addBox(-3.0F, -4.658F, 1.9397F, 5.0F, 6.0F, 2.0F, 0.0F, false);
			body.setTextureOffset(17, 50).addBox(0.0F, 0.2214F, 1.2557F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(4.0F, 2.0F, -4.0F);
			left_arm.setTextureOffset(40, 16).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			left_arm.setTextureOffset(9, 50).addBox(1.5F, -0.5F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			left_arm.setTextureOffset(12, 49).addBox(2.5F, 6.5F, 0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			left_arm.setTextureOffset(12, 49).addBox(2.6F, 1.5F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			left_arm.setTextureOffset(13, 51).addBox(0.5F, 8.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			left_arm.setTextureOffset(13, 51).addBox(1.5F, 7.5F, -2.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-4.0F, 2.0F, -4.0F);
			right_arm.setTextureOffset(40, 16).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			right_arm.setTextureOffset(12, 49).addBox(-4.5F, 9.5F, -2.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			right_arm.setTextureOffset(12, 49).addBox(-1.5F, -0.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			right_arm.setTextureOffset(19, 50).addBox(-4.5F, 3.5F, 0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			right_arm.setTextureOffset(13, 51).addBox(-1.5F, 5.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(2.1F, 12.0F, 0.0F);
			left_leg.setTextureOffset(0, 16).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			left_leg.setTextureOffset(3, 52).addBox(-0.6F, 2.5F, -2.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			left_leg.setTextureOffset(3, 52).addBox(-1.6F, 5.5F, -0.4F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			left_leg.setTextureOffset(12, 49).addBox(0.4F, 8.5F, 0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			left_leg.setTextureOffset(12, 49).addBox(-1.6F, 5.5F, -2.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-2.1F, 12.0F, 0.0F);
			right_leg.setTextureOffset(0, 16).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			right_leg.setTextureOffset(8, 51).addBox(-2.4F, 9.5F, -2.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			right_leg.setTextureOffset(3, 52).addBox(-2.4F, 1.5F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			right_leg.setTextureOffset(12, 49).addBox(-2.4F, 6.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			right_leg.setTextureOffset(12, 49).addBox(-1.4F, 5.5F, -2.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			right_leg.setTextureOffset(12, 49).addBox(-0.4F, 3.5F, 0.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
