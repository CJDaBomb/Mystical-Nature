
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
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;

import net.mcreator.mysticalnature.MysticalNatureModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MysticalNatureModElements.ModElement.Tag
public class BloodSpiderEntity extends MysticalNatureModElements.ModElement {
	public static EntityType entity = null;
	public BloodSpiderEntity(MysticalNatureModElements instance) {
		super(instance, 192);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 0.5f)).build("blood_spider")
						.setRegistryName("blood_spider");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -3407872, -6750208, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("blood_spider"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mystical_nature:bloody_thorns_valley")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 40, 2, 6));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelBloodSpider(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("mystical_nature:textures/bloodspider.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
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
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12);
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
	public static class ModelBloodSpider extends EntityModel<Entity> {
		private final ModelRenderer left_leg1;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer left_leg2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer left_leg3;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer right_leg1;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer right_leg2;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer right_leg3;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer right_leg4;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer Head;
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r15;
		public ModelBloodSpider() {
			textureWidth = 32;
			textureHeight = 32;
			left_leg1 = new ModelRenderer(this);
			left_leg1.setRotationPoint(0.5F, 22.0833F, -2.3F);
			setRotationAngle(left_leg1, 0.0F, 0.4363F, 0.0F);
			left_leg1.setTextureOffset(3, 2).addBox(4.3642F, 1.9167F, -1.0448F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(2.7915F, -0.8333F, 0.3615F);
			left_leg1.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, 1.1781F);
			cube_r1.setTextureOffset(15, 17).addBox(-0.8383F, -0.3904F, -1.4063F, 4.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(1.6415F, -1.0833F, 0.3615F);
			left_leg1.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, -0.6981F);
			cube_r2.setTextureOffset(0, 13).addBox(-0.6763F, 0.2717F, -1.4063F, 2.0F, 0.0F, 1.0F, 0.0F, false);
			left_leg2 = new ModelRenderer(this);
			left_leg2.setRotationPoint(0.5F, 22.0F, -2.0F);
			left_leg2.setTextureOffset(2, 15).addBox(3.8F, 2.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(2.65F, -0.75F, -0.5F);
			left_leg2.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.0F, 1.1781F);
			cube_r3.setTextureOffset(18, 15).addBox(-1.0F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(1.5F, -1.0F, -0.5F);
			left_leg2.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, -0.6981F);
			cube_r4.setTextureOffset(0, 16).addBox(0.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			left_leg3 = new ModelRenderer(this);
			left_leg3.setRotationPoint(0.4167F, 22.0833F, -2.5F);
			setRotationAngle(left_leg3, 0.0F, -0.4363F, 0.0F);
			left_leg3.setTextureOffset(3, 1).addBox(4.4095F, 1.9167F, -0.2816F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(2.8369F, -0.8333F, 1.1247F);
			left_leg3.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, 1.1781F);
			cube_r5.setTextureOffset(16, 13).addBox(-0.8383F, -0.3904F, -1.4063F, 4.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(1.6869F, -1.0833F, 1.1247F);
			left_leg3.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, -0.6981F);
			cube_r6.setTextureOffset(0, 12).addBox(-0.6763F, 0.2717F, -1.4063F, 2.0F, 0.0F, 1.0F, 0.0F, false);
			right_leg1 = new ModelRenderer(this);
			right_leg1.setRotationPoint(0.5F, 22.0F, -2.75F);
			setRotationAngle(right_leg1, 0.0F, -0.4363F, 0.0F);
			right_leg1.setTextureOffset(10, 12).addBox(-5.2837F, 2.0F, -0.4711F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-2.7111F, -0.75F, 0.9352F);
			right_leg1.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, 0.0F, -1.1781F);
			cube_r7.setTextureOffset(15, 18).addBox(-3.1617F, -0.3904F, -1.4063F, 4.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-1.5611F, -1.0F, 0.9352F);
			right_leg1.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, 0.0F, 0.6981F);
			cube_r8.setTextureOffset(0, 14).addBox(-1.3237F, 0.2717F, -1.4063F, 2.0F, 0.0F, 1.0F, 0.0F, false);
			right_leg2 = new ModelRenderer(this);
			right_leg2.setRotationPoint(0.5F, 24.0F, -2.0F);
			right_leg2.setTextureOffset(10, 13).addBox(-4.8F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-2.65F, -2.75F, -0.5F);
			right_leg2.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.0F, -1.1781F);
			cube_r9.setTextureOffset(18, 14).addBox(-3.0F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(-1.5F, -3.0F, -0.5F);
			right_leg2.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.0F, 0.0F, 0.6981F);
			cube_r10.setTextureOffset(0, 15).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			right_leg3 = new ModelRenderer(this);
			right_leg3.setRotationPoint(0.3833F, 22.0833F, -2.3F);
			setRotationAngle(right_leg3, 0.0F, 0.4363F, 0.0F);
			right_leg3.setTextureOffset(3, 0).addBox(-5.1437F, 1.9167F, -0.3783F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-2.5711F, -0.8333F, 1.028F);
			right_leg3.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, 0.0F, -1.1781F);
			cube_r11.setTextureOffset(16, 12).addBox(-3.1617F, -0.3904F, -1.4063F, 4.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-1.4211F, -1.0833F, 1.028F);
			right_leg3.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0F, 0.0F, 0.6981F);
			cube_r12.setTextureOffset(0, 5).addBox(-1.3237F, 0.2717F, -1.4063F, 2.0F, 0.0F, 1.0F, 0.0F, false);
			right_leg4 = new ModelRenderer(this);
			right_leg4.setRotationPoint(0.5F, 22.0F, -2.75F);
			setRotationAngle(right_leg4, 0.0F, -0.4363F, 0.0F);
			right_leg4.setTextureOffset(3, 3).addBox(-5.2837F, 2.0F, -0.4711F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(-2.7111F, -0.75F, 0.9352F);
			right_leg4.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.0F, 0.0F, -1.1781F);
			cube_r13.setTextureOffset(10, 16).addBox(-3.1617F, -0.3904F, -1.4063F, 4.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-1.5611F, -1.0F, 0.9352F);
			right_leg4.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.0F, 0.0F, 0.6981F);
			cube_r14.setTextureOffset(0, 4).addBox(-1.3237F, 0.2717F, -1.4063F, 2.0F, 0.0F, 1.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.5F, 22.5F, -4.0F);
			Head.setTextureOffset(11, 12).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Head.setTextureOffset(0, 2).addBox(-1.5F, 0.1F, -3.5F, 1.0F, 0.0F, 2.0F, 0.0F, false);
			Head.setTextureOffset(0, 0).addBox(0.5F, 0.1F, -3.5F, 1.0F, 0.0F, 2.0F, 0.0F, false);
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 12).addBox(-1.0F, -3.0F, -4.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(0.5F, -3.55F, 2.4F);
			bb_main.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.4363F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(0, 0).addBox(-3.5F, -3.0F, -3.0F, 7.0F, 6.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			left_leg1.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg3.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg1.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg3.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg4.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.right_leg1.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.right_leg2.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.left_leg1.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.left_leg2.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_leg3.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.right_leg3.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
