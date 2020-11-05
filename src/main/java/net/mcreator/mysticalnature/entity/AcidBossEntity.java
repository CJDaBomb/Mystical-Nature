
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.mysticalnature.item.AcidBossAttackItem;
import net.mcreator.mysticalnature.MysticalNatureModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MysticalNatureModElements.ModElement.Tag
public class AcidBossEntity extends MysticalNatureModElements.ModElement {
	public static EntityType entity = null;
	public AcidBossEntity(MysticalNatureModElements instance) {
		super(instance, 54);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(1f, 2.7f)).build("acid_boss")
						.setRegistryName("acid_boss");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("acid_boss"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelHeartlessBoss(), 1f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("mystical_nature:textures/acidboss.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {
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
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, false));
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0));
			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
				@Override
				public boolean shouldContinueExecuting() {
					return this.shouldExecute();
				}
			});
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
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.001);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			AcidBossAttackItem.shoot(this, target);
		}

		@Override
		public boolean canBeCollidedWith() {
			return false;
		}
	}

	// Made with Blockbench 3.7.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelHeartlessBoss extends EntityModel<Entity> {
		private final ModelRenderer TUDO;
		private final ModelRenderer Head;
		private final ModelRenderer Body;
		private final ModelRenderer bone2;
		private final ModelRenderer cube_r12;
		private final ModelRenderer bone3;
		private final ModelRenderer bone4;
		private final ModelRenderer Arch;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer Arch2;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer Arch3;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r13;
		private final ModelRenderer Arch4;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer Arch5;
		private final ModelRenderer cube_r17;
		private final ModelRenderer cube_r18;
		private final ModelRenderer cube_r19;
		private final ModelRenderer Arch6;
		private final ModelRenderer cube_r20;
		private final ModelRenderer cube_r21;
		private final ModelRenderer cube_r22;
		public ModelHeartlessBoss() {
			textureWidth = 256;
			textureHeight = 256;
			TUDO = new ModelRenderer(this);
			TUDO.setRotationPoint(0.0F, 24.0F, 0.0F);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, -53.0F, 9.0F);
			TUDO.addChild(Head);
			Head.setTextureOffset(0, 170).addBox(-8.0F, -14.0F, -8.0F, 16.0F, 14.0F, 15.0F, 0.0F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			TUDO.addChild(Body);
			Body.setTextureOffset(82, 0).addBox(-6.0F, -49.0F, 5.0F, 12.0F, 24.0F, 8.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, -26.0F, 10.0F);
			Body.addChild(bone2);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(0.0F, 1.0F, -1.0F);
			bone2.addChild(cube_r12);
			setRotationAngle(cube_r12, -0.7854F, 0.0F, 0.0F);
			cube_r12.setTextureOffset(0, 145).addBox(-5.0F, -3.1716F, -3.8284F, 9.0F, 18.0F, 6.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(-0.25F, 14.5598F, -0.9234F);
			cube_r12.addChild(bone3);
			setRotationAngle(bone3, -0.9599F, 0.0F, 0.0F);
			bone3.setTextureOffset(0, 33).addBox(-3.75F, -2.2359F, -2.1808F, 7.0F, 11.0F, 4.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(-0.75F, 8.4785F, 0.0807F);
			bone3.addChild(bone4);
			setRotationAngle(bone4, -0.6109F, 0.0F, 0.0F);
			bone4.setTextureOffset(41, 41).addBox(-2.0F, -1.0492F, -2.7614F, 5.0F, 11.0F, 4.0F, 0.0F, false);
			Arch = new ModelRenderer(this);
			Arch.setRotationPoint(-6.0F, -38.0F, 10.0F);
			TUDO.addChild(Arch);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(20.0F, 0.0F, -17.0F);
			Arch.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.6981F, 0.0F);
			cube_r4.setTextureOffset(74, 20).addBox(-2.0F, -2.0F, -12.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(17.0F, 1.0F, -4.0F);
			Arch.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, -0.1309F, 0.0F);
			cube_r5.setTextureOffset(74, 19).addBox(-2.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(14.0F, 0.0F, -3.5F);
			Arch.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.5672F, 0.0F);
			cube_r6.setTextureOffset(104, 87).addBox(-5.0F, -3.0F, -3.5F, 10.0F, 6.0F, 7.0F, 0.0F, false);
			Arch2 = new ModelRenderer(this);
			Arch2.setRotationPoint(5.0F, -37.0F, 9.0F);
			TUDO.addChild(Arch2);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-19.0F, -1.0F, -16.0F);
			Arch2.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, -0.6981F, 0.0F);
			cube_r7.setTextureOffset(74, 27).addBox(-2.0F, -2.0F, -12.0F, 4.0F, 4.0F, 12.0F, 0.0F, true);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-16.0F, 0.0F, -3.0F);
			Arch2.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, 0.1309F, 0.0F);
			cube_r8.setTextureOffset(22, 51).addBox(-3.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, true);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-13.0F, -1.0F, -2.5F);
			Arch2.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, -0.5672F, 0.0F);
			cube_r9.setTextureOffset(78, 29).addBox(-5.0F, -3.0F, -3.5F, 10.0F, 6.0F, 7.0F, 0.0F, true);
			Arch3 = new ModelRenderer(this);
			Arch3.setRotationPoint(5.0F, -32.0F, 11.0F);
			TUDO.addChild(Arch3);
			setRotationAngle(Arch3, 0.0F, 0.0F, 0.3054F);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(9.0F, 0.0F, -18.0F);
			Arch3.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.0F, 0.6981F, 0.0F);
			cube_r10.setTextureOffset(74, 14).addBox(-2.0F, -2.0F, -16.0F, 4.0F, 4.0F, 16.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(6.0F, 1.0F, -5.0F);
			Arch3.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, -0.1309F, 0.0F);
			cube_r11.setTextureOffset(72, 19).addBox(-2.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(3.0F, 0.0F, -4.5F);
			Arch3.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.0F, 0.5672F, 0.0F);
			cube_r13.setTextureOffset(79, 25).addBox(-6.0F, -3.0F, -3.5F, 11.0F, 6.0F, 7.0F, 0.0F, false);
			Arch4 = new ModelRenderer(this);
			Arch4.setRotationPoint(-5.0F, -32.0F, 11.0F);
			TUDO.addChild(Arch4);
			setRotationAngle(Arch4, 0.0F, 0.0F, -0.3054F);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-9.0F, 0.0F, -18.0F);
			Arch4.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.0F, -0.6981F, 0.0F);
			cube_r14.setTextureOffset(81, 16).addBox(-2.0F, -2.0F, -16.0F, 4.0F, 4.0F, 16.0F, 0.0F, true);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-6.0F, 1.0F, -5.0F);
			Arch4.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.0F, 0.1309F, 0.0F);
			cube_r15.setTextureOffset(72, 17).addBox(-3.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, true);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(-3.0F, 0.0F, -4.5F);
			Arch4.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.0F, -0.5672F, 0.0F);
			cube_r16.setTextureOffset(72, 29).addBox(-5.0F, -3.0F, -3.5F, 11.0F, 6.0F, 7.0F, 0.0F, true);
			Arch5 = new ModelRenderer(this);
			Arch5.setRotationPoint(5.0F, -43.0F, 7.0F);
			TUDO.addChild(Arch5);
			setRotationAngle(Arch5, 0.0F, 0.0F, -0.3054F);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(9.0F, -2.0F, -14.0F);
			Arch5.addChild(cube_r17);
			setRotationAngle(cube_r17, 0.0F, 0.6981F, 0.0F);
			cube_r17.setTextureOffset(70, 15).addBox(-2.0F, -2.0F, -16.0F, 4.0F, 4.0F, 16.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(6.0F, -1.0F, -1.0F);
			Arch5.addChild(cube_r18);
			setRotationAngle(cube_r18, 0.0F, -0.1309F, 0.0F);
			cube_r18.setTextureOffset(53, 48).addBox(-2.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(3.0F, -2.0F, -0.5F);
			Arch5.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.0F, 0.5672F, 0.0F);
			cube_r19.setTextureOffset(83, 19).addBox(-5.0F, -3.0F, -3.5F, 10.0F, 6.0F, 7.0F, 0.0F, false);
			Arch6 = new ModelRenderer(this);
			Arch6.setRotationPoint(-5.0F, -43.0F, 7.0F);
			TUDO.addChild(Arch6);
			setRotationAngle(Arch6, 0.0F, 0.0F, 0.3054F);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(-9.0F, -2.0F, -14.0F);
			Arch6.addChild(cube_r20);
			setRotationAngle(cube_r20, 0.0F, -0.6981F, 0.0F);
			cube_r20.setTextureOffset(72, 23).addBox(-2.0F, -2.0F, -16.0F, 4.0F, 4.0F, 16.0F, 0.0F, true);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(-6.0F, -1.0F, -1.0F);
			Arch6.addChild(cube_r21);
			setRotationAngle(cube_r21, 0.0F, 0.1309F, 0.0F);
			cube_r21.setTextureOffset(76, 15).addBox(-3.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, true);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(-3.0F, -2.0F, -0.5F);
			Arch6.addChild(cube_r22);
			setRotationAngle(cube_r22, 0.0F, -0.5672F, 0.0F);
			cube_r22.setTextureOffset(108, 92).addBox(-5.0F, -3.0F, -3.5F, 10.0F, 6.0F, 7.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			TUDO.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
