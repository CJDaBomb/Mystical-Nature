
package net.mcreator.mysticalnature.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
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
public class SulfuricGolemEntity extends MysticalNatureModElements.ModElement {
	public static EntityType entity = null;
	public SulfuricGolemEntity(MysticalNatureModElements instance) {
		super(instance, 21);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(2f, 3f)).build("sulfuric_golem")
						.setRegistryName("sulfuric_golem");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -13421773, -3355648, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("sulfuric_golem"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelGolem(), 2f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("mystical_nature:textures/golem.png");
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
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
	public static class ModelGolem extends EntityModel<Entity> {
		private final ModelRenderer All;
		private final ModelRenderer Body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer Rarm;
		private final ModelRenderer Larm;
		private final ModelRenderer Rleg;
		private final ModelRenderer Lleg;
		private final ModelRenderer Head;
		public ModelGolem() {
			textureWidth = 256;
			textureHeight = 256;
			All = new ModelRenderer(this);
			All.setRotationPoint(16.0F, 24.0F, 0.0F);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			All.addChild(Body);
			Body.setTextureOffset(54, 56).addBox(-26.5F, -22.0F, 4.0F, 21.0F, 9.0F, 15.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-14.0F, -36.0F, 3.5F);
			Body.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.5672F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 32).addBox(-12.0F, -5.0F, -8.5F, 20.0F, 25.0F, 14.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-14.5F, -41.5F, -4.0F);
			Body.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.7854F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(0, 0).addBox(-17.5F, -7.5F, -9.0F, 31.0F, 15.0F, 17.0F, 0.0F, false);
			Rarm = new ModelRenderer(this);
			Rarm.setRotationPoint(-30.0F, -46.0F, -4.0F);
			All.addChild(Rarm);
			Rarm.setTextureOffset(81, 17).addBox(-10.5F, 31.0F, -7.5F, 15.0F, 15.0F, 15.0F, 0.0F, false);
			Rarm.setTextureOffset(0, 101).addBox(-8.5F, 0.0F, -5.5F, 11.0F, 32.0F, 11.0F, 0.0F, false);
			Larm = new ModelRenderer(this);
			Larm.setRotationPoint(1.0F, -46.0F, -4.0F);
			All.addChild(Larm);
			Larm.setTextureOffset(44, 110).addBox(-6.5F, 0.0F, -5.5F, 11.0F, 32.0F, 11.0F, 0.0F, false);
			Larm.setTextureOffset(81, 17).addBox(-8.5F, 31.0F, -7.5F, 15.0F, 15.0F, 15.0F, 0.0F, false);
			Rleg = new ModelRenderer(this);
			Rleg.setRotationPoint(-21.0F, -15.0F, 12.0F);
			All.addChild(Rleg);
			Rleg.setTextureOffset(88, 110).addBox(-7.0F, -1.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);
			Lleg = new ModelRenderer(this);
			Lleg.setRotationPoint(-7.0F, -16.0F, 11.0F);
			All.addChild(Lleg);
			Lleg.setTextureOffset(122, 70).addBox(-7.0F, 0.0F, -4.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(-15.0F, -43.0F, -7.0F);
			All.addChild(Head);
			Head.setTextureOffset(0, 71).addBox(-9.0F, -8.0F, -14.0F, 15.0F, 14.0F, 16.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			All.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.Lleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Rleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Rarm.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
