
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
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
public class SatyrEntity extends MysticalNatureModElements.ModElement {
	public static EntityType entity = null;
	public SatyrEntity(MysticalNatureModElements instance) {
		super(instance, 195);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("satyr")
						.setRegistryName("satyr");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -65536, -10066330, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("satyr"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mystical_nature:bloody_thorns_valley")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 1, 1));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelSatyr(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("mystical_nature:textures/satyr.png");
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
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1));
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
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.7.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelSatyr extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer bone6;
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bone4;
		private final ModelRenderer bone5;
		private final ModelRenderer bone3;
		private final ModelRenderer bone7;
		private final ModelRenderer bone8;
		private final ModelRenderer bone9;
		private final ModelRenderer bone10;
		private final ModelRenderer bone11;
		private final ModelRenderer bone12;
		private final ModelRenderer bone13;
		private final ModelRenderer bone14;
		private final ModelRenderer bone16;
		private final ModelRenderer bone17;
		private final ModelRenderer body;
		private final ModelRenderer bone15;
		private final ModelRenderer left_arm;
		private final ModelRenderer right_arm;
		private final ModelRenderer left_leg;
		private final ModelRenderer left_leg_r1;
		private final ModelRenderer left_leg2;
		private final ModelRenderer left_leg_r2;
		public ModelSatyr() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(bone6);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(3.5F, -7.5F, -1.5F);
			bone6.addChild(bone);
			setRotationAngle(bone, -0.4538F, 0.0F, 0.8727F);
			bone.setTextureOffset(44, 12).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(5.1F, -8.6F, 0.4F);
			bone6.addChild(bone2);
			setRotationAngle(bone2, -0.1309F, 0.4363F, -0.6981F);
			bone2.setTextureOffset(28, 12).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(6.25F, -5.25F, 2.05F);
			bone6.addChild(bone4);
			setRotationAngle(bone4, -0.7854F, -0.2182F, 0.0F);
			bone4.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(6.9F, -3.8F, 0.3F);
			bone6.addChild(bone5);
			setRotationAngle(bone5, -0.0873F, -0.2182F, 0.0F);
			bone5.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(5.85F, -7.1F, 2.7F);
			bone6.addChild(bone3);
			setRotationAngle(bone3, 0.6545F, 0.2618F, 0.0F);
			bone3.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(bone7);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(-3.5F, -7.5F, -1.5F);
			bone7.addChild(bone8);
			setRotationAngle(bone8, -0.4538F, 0.0F, -0.8727F);
			bone8.setTextureOffset(45, 12).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, true);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(-5.1F, -8.6F, 0.4F);
			bone7.addChild(bone9);
			setRotationAngle(bone9, -0.1309F, -0.4363F, 0.6981F);
			bone9.setTextureOffset(28, 12).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, true);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(-6.25F, -5.25F, 2.05F);
			bone7.addChild(bone10);
			setRotationAngle(bone10, -0.7854F, 0.2182F, 0.0F);
			bone10.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(-6.9F, -3.8F, 0.3F);
			bone7.addChild(bone11);
			setRotationAngle(bone11, -0.0873F, 0.2182F, 0.0F);
			bone11.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);
			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(-5.85F, -7.1F, 2.7F);
			bone7.addChild(bone12);
			setRotationAngle(bone12, 0.6545F, -0.2618F, 0.0F);
			bone12.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);
			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(4.5F, -3.6F, -1.0F);
			head.addChild(bone13);
			setRotationAngle(bone13, 0.0F, 0.0F, -0.6109F);
			bone13.setTextureOffset(16, 47).addBox(-0.5491F, -1.7785F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			bone14 = new ModelRenderer(this);
			bone14.setRotationPoint(-4.5F, -3.6F, -1.0F);
			head.addChild(bone14);
			setRotationAngle(bone14, 0.0F, 0.0F, 0.6109F);
			bone14.setTextureOffset(16, 47).addBox(-0.4509F, -1.7785F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, true);
			bone16 = new ModelRenderer(this);
			bone16.setRotationPoint(-1.5F, -0.9F, -4.6F);
			head.addChild(bone16);
			setRotationAngle(bone16, 1.0472F, 0.0F, 0.0F);
			bone17 = new ModelRenderer(this);
			bone17.setRotationPoint(1.5F, -0.9F, -4.6F);
			head.addChild(bone17);
			setRotationAngle(bone17, 1.0472F, 0.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.setTextureOffset(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			bone15 = new ModelRenderer(this);
			bone15.setRotationPoint(0.0F, 12.1F, 2.5F);
			body.addChild(bone15);
			setRotationAngle(bone15, 0.6981F, 0.0F, 0.0F);
			bone15.setTextureOffset(21, 45).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			left_arm.setTextureOffset(24, 24).addBox(9.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
			right_arm.setTextureOffset(24, 24).addBox(-13.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(2.1F, 12.5F, 0.0F);
			setRotationAngle(left_leg, -0.2967F, 0.0F, 0.0F);
			left_leg_r1 = new ModelRenderer(this);
			left_leg_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			left_leg.addChild(left_leg_r1);
			setRotationAngle(left_leg_r1, -0.2967F, 0.0F, 0.0F);
			left_leg_r1.setTextureOffset(32, 48).addBox(-1.9F, 6.9519F, -0.2381F, 4.0F, 5.0F, 4.0F, 0.0F, false);
			left_leg_r1.setTextureOffset(20, 48).addBox(-1.9F, 4.9519F, 1.7619F, 4.0F, 2.0F, 2.0F, 0.0F, false);
			left_leg_r1.setTextureOffset(16, 40).addBox(-1.9F, -1.0481F, -2.2381F, 4.0F, 8.0F, 4.0F, 0.0F, false);
			left_leg2 = new ModelRenderer(this);
			left_leg2.setRotationPoint(-2.1F, 12.5F, 0.0F);
			setRotationAngle(left_leg2, -0.2967F, 0.0F, 0.0F);
			left_leg_r2 = new ModelRenderer(this);
			left_leg_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			left_leg2.addChild(left_leg_r2);
			setRotationAngle(left_leg_r2, -0.2967F, 0.0F, 0.0F);
			left_leg_r2.setTextureOffset(32, 48).addBox(-1.9F, 6.9519F, -0.2381F, 4.0F, 5.0F, 4.0F, 0.0F, false);
			left_leg_r2.setTextureOffset(20, 48).addBox(-1.9F, 4.9519F, 1.7619F, 4.0F, 2.0F, 2.0F, 0.0F, false);
			left_leg_r2.setTextureOffset(16, 40).addBox(-1.9F, -1.0481F, -2.2381F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.left_leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
