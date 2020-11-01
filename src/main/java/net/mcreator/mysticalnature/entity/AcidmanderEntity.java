
package net.mcreator.mysticalnature.entity;

import net.minecraft.block.material.Material;

@MysticalNatureModElements.ModElement.Tag
public class AcidmanderEntity extends MysticalNatureModElements.ModElement {

	public static EntityType entity = null;

	public AcidmanderEntity(MysticalNatureModElements instance) {
		super(instance, 19);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("acidmander")
						.setRegistryName("acidmander");

		elements.entities.add(() -> entity);

		elements.items
				.add(() -> new SpawnEggItem(entity, -6697984, -13421773, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("acidmander"));

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelAcidmander(), 0.5f) {

				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("mystical_nature:textures/acidsalamander.png");
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

	// Made with Blockbench 3.7.1
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	public static class ModelAcidmander extends EntityModel<Entity> {
		private final ModelRenderer UpperTorso;
		private final ModelRenderer bone;
		private final ModelRenderer LUpperLeg;
		private final ModelRenderer bone2_r1;
		private final ModelRenderer bone2;
		private final ModelRenderer bone50;
		private final ModelRenderer bone9;
		private final ModelRenderer bone5_r1;
		private final ModelRenderer bone6_r1;
		private final ModelRenderer bone4_r1;
		private final ModelRenderer bone3_r1;
		private final ModelRenderer bone3;
		private final ModelRenderer bone4;
		private final ModelRenderer bone6;
		private final ModelRenderer bone5;
		private final ModelRenderer RUpperLeg;
		private final ModelRenderer bone41_r1;
		private final ModelRenderer bone41;
		private final ModelRenderer bone51;
		private final ModelRenderer bone10;
		private final ModelRenderer bone45_r1;
		private final ModelRenderer bone44_r1;
		private final ModelRenderer bone43_r1;
		private final ModelRenderer bone42_r1;
		private final ModelRenderer bone42;
		private final ModelRenderer bone43;
		private final ModelRenderer bone44;
		private final ModelRenderer bone45;
		private final ModelRenderer BackTorso;
		private final ModelRenderer Tail1_r1;
		private final ModelRenderer bone16;
		private final ModelRenderer LDownLeg;
		private final ModelRenderer bone24_r1;
		private final ModelRenderer bone24;
		private final ModelRenderer bone7;
		private final ModelRenderer bone27_r1;
		private final ModelRenderer bone28_r1;
		private final ModelRenderer bone26_r1;
		private final ModelRenderer bone25_r1;
		private final ModelRenderer bone25;
		private final ModelRenderer bone26;
		private final ModelRenderer bone28;
		private final ModelRenderer bone27;
		private final ModelRenderer RDownLeg;
		private final ModelRenderer bone53_r1;
		private final ModelRenderer bone53;
		private final ModelRenderer bone8;
		private final ModelRenderer bone57_r1;
		private final ModelRenderer bone56_r1;
		private final ModelRenderer bone55_r1;
		private final ModelRenderer bone54_r1;
		private final ModelRenderer bone54;
		private final ModelRenderer bone55;
		private final ModelRenderer bone56;
		private final ModelRenderer bone57;
		private final ModelRenderer Tail1;
		private final ModelRenderer Tail2_r1;
		private final ModelRenderer Tail2;
		private final ModelRenderer Tail3_r1;
		private final ModelRenderer Tail3;
		private final ModelRenderer MiddleTorso;
		private final ModelRenderer bone35_r1;
		private final ModelRenderer bone35;
		private final ModelRenderer Head;
		private final ModelRenderer bone39_r1;
		private final ModelRenderer bone32;
		private final ModelRenderer bone33;
		private final ModelRenderer bone49;
		private final ModelRenderer bone39;

		public ModelAcidmander() {
			textureWidth = 128;
			textureHeight = 128;

			UpperTorso = new ModelRenderer(this);
			UpperTorso.setRotationPoint(0.0F, 24.0F, 0.0F);

			bone = new ModelRenderer(this);
			bone.setRotationPoint(-2.0F, -7.0F, -5.0F);
			UpperTorso.addChild(bone);
			bone.setTextureOffset(23, 25).addBox(-3.0F, -2.0F, -5.0F, 8.0F, 7.0F, 7.0F, 0.0F, false);
			bone.setTextureOffset(18, 32).addBox(0.5F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 32).addBox(0.5F, -3.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(30, 10).addBox(0.5F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

			LUpperLeg = new ModelRenderer(this);
			LUpperLeg.setRotationPoint(3.0F, -5.5F, -6.5F);
			UpperTorso.addChild(LUpperLeg);

			bone2_r1 = new ModelRenderer(this);
			bone2_r1.setRotationPoint(1.5F, 0.0F, -2.0F);
			LUpperLeg.addChild(bone2_r1);
			setRotationAngle(bone2_r1, 0.0F, 0.0F, -1.309F);

			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(1.5F, 0.0F, -2.0F);
			LUpperLeg.addChild(bone2);
			setRotationAngle(bone2, 0.0F, 0.0F, -1.309F);
			bone2.setTextureOffset(48, 10).addBox(-1.5F, -2.5F, 0.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);

			bone50 = new ModelRenderer(this);
			bone50.setRotationPoint(5.0F, 0.0F, 0.0F);
			bone2.addChild(bone50);
			bone50.setTextureOffset(23, 23).addBox(-3.9319F, -0.4824F, 1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(3.5F, 0.6993F, -0.5F);
			LUpperLeg.addChild(bone9);

			bone5_r1 = new ModelRenderer(this);
			bone5_r1.setRotationPoint(1.5F, 2.8007F, -4.5F);
			bone9.addChild(bone5_r1);
			setRotationAngle(bone5_r1, 0.0F, 0.1309F, 0.0F);

			bone6_r1 = new ModelRenderer(this);
			bone6_r1.setRotationPoint(1.5F, 4.8007F, -3.5F);
			bone9.addChild(bone6_r1);
			setRotationAngle(bone6_r1, 0.0F, -0.6109F, 0.0F);

			bone4_r1 = new ModelRenderer(this);
			bone4_r1.setRotationPoint(2.5F, 4.8007F, -2.5F);
			bone9.addChild(bone4_r1);
			setRotationAngle(bone4_r1, 0.0F, -1.4835F, 0.0F);

			bone3_r1 = new ModelRenderer(this);
			bone3_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone9.addChild(bone3_r1);
			setRotationAngle(bone3_r1, -0.3054F, 0.0F, -0.3491F);

			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone9.addChild(bone3);
			setRotationAngle(bone3, -0.3054F, 0.0F, -0.3491F);
			bone3.setTextureOffset(54, 54).addBox(-0.684F, -0.7776F, -0.6146F, 2.0F, 5.0F, 2.0F, 0.0F, false);

			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(2.5F, 4.8007F, -2.5F);
			bone9.addChild(bone4);
			setRotationAngle(bone4, 0.0F, -1.4835F, 0.0F);
			bone4.setTextureOffset(44, 58).addBox(1.5795F, -1.5F, -2.3219F, 1.0F, 1.0F, 3.0F, 0.0F, false);

			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(1.5F, 4.8007F, -3.5F);
			bone9.addChild(bone6);
			setRotationAngle(bone6, 0.0F, -0.6109F, 0.0F);
			bone6.setTextureOffset(0, 52).addBox(1.4663F, -1.5F, -1.4353F, 1.0F, 1.0F, 4.0F, 0.0F, false);

			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(1.5F, 2.8007F, -4.5F);
			bone9.addChild(bone5);
			setRotationAngle(bone5, 0.0F, 0.1309F, 0.0F);
			bone5.setTextureOffset(57, 43).addBox(-0.9696F, 0.5F, 0.622F, 1.0F, 1.0F, 3.0F, 0.0F, false);

			RUpperLeg = new ModelRenderer(this);
			RUpperLeg.setRotationPoint(-5.5F, -5.5F, -6.5F);
			UpperTorso.addChild(RUpperLeg);

			bone41_r1 = new ModelRenderer(this);
			bone41_r1.setRotationPoint(-1.0F, 0.0F, -2.0F);
			RUpperLeg.addChild(bone41_r1);
			setRotationAngle(bone41_r1, 0.0F, 0.0F, 1.309F);

			bone41 = new ModelRenderer(this);
			bone41.setRotationPoint(-1.0F, 0.0F, -2.0F);
			RUpperLeg.addChild(bone41);
			setRotationAngle(bone41, 0.0F, 0.0F, 1.309F);
			bone41.setTextureOffset(24, 48).addBox(-1.5F, -2.5F, 0.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);

			bone51 = new ModelRenderer(this);
			bone51.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone41.addChild(bone51);
			bone51.setTextureOffset(0, 22).addBox(-3.2247F, -0.2929F, 1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(-3.0F, 0.6993F, -0.5F);
			RUpperLeg.addChild(bone10);

			bone45_r1 = new ModelRenderer(this);
			bone45_r1.setRotationPoint(-1.5F, 2.8007F, -4.5F);
			bone10.addChild(bone45_r1);
			setRotationAngle(bone45_r1, 0.0F, -0.1309F, 0.0F);

			bone44_r1 = new ModelRenderer(this);
			bone44_r1.setRotationPoint(-1.5F, 4.8007F, -3.5F);
			bone10.addChild(bone44_r1);
			setRotationAngle(bone44_r1, 0.0F, 0.6109F, 0.0F);

			bone43_r1 = new ModelRenderer(this);
			bone43_r1.setRotationPoint(-2.5F, 4.8007F, -2.5F);
			bone10.addChild(bone43_r1);
			setRotationAngle(bone43_r1, 0.0F, 1.4835F, 0.0F);

			bone42_r1 = new ModelRenderer(this);
			bone42_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone10.addChild(bone42_r1);
			setRotationAngle(bone42_r1, -0.3054F, 0.0F, 0.3491F);

			bone42 = new ModelRenderer(this);
			bone42.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone10.addChild(bone42);
			setRotationAngle(bone42, -0.3054F, 0.0F, 0.3491F);
			bone42.setTextureOffset(46, 50).addBox(-1.316F, -0.7776F, -0.6146F, 2.0F, 5.0F, 2.0F, 0.0F, false);

			bone43 = new ModelRenderer(this);
			bone43.setRotationPoint(-2.5F, 4.8007F, -2.5F);
			bone10.addChild(bone43);
			setRotationAngle(bone43, 0.0F, 1.4835F, 0.0F);
			bone43.setTextureOffset(26, 57).addBox(-2.5795F, -1.5F, -2.3219F, 1.0F, 1.0F, 3.0F, 0.0F, false);

			bone44 = new ModelRenderer(this);
			bone44.setRotationPoint(-1.5F, 4.8007F, -3.5F);
			bone10.addChild(bone44);
			setRotationAngle(bone44, 0.0F, 0.6109F, 0.0F);
			bone44.setTextureOffset(36, 50).addBox(-2.4663F, -1.5F, -1.4353F, 1.0F, 1.0F, 4.0F, 0.0F, false);

			bone45 = new ModelRenderer(this);
			bone45.setRotationPoint(-1.5F, 2.8007F, -4.5F);
			bone10.addChild(bone45);
			setRotationAngle(bone45, 0.0F, -0.1309F, 0.0F);
			bone45.setTextureOffset(12, 57).addBox(-0.0304F, 0.5F, 0.622F, 1.0F, 1.0F, 3.0F, 0.0F, false);

			BackTorso = new ModelRenderer(this);
			BackTorso.setRotationPoint(0.0F, 24.0F, 15.0F);

			Tail1_r1 = new ModelRenderer(this);
			Tail1_r1.setRotationPoint(-1.0F, -5.0F, -3.5F);
			BackTorso.addChild(Tail1_r1);
			setRotationAngle(Tail1_r1, -0.5236F, 0.0F, 0.0F);

			bone16 = new ModelRenderer(this);
			bone16.setRotationPoint(-2.0F, -7.0F, -5.0F);
			BackTorso.addChild(bone16);
			bone16.setTextureOffset(0, 18).addBox(-3.0F, -1.0F, -5.0F, 8.0F, 7.0F, 7.0F, 0.0F, false);
			bone16.setTextureOffset(29, 5).addBox(0.5F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone16.setTextureOffset(29, 2).addBox(0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone16.setTextureOffset(26, 10).addBox(0.5F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

			LDownLeg = new ModelRenderer(this);
			LDownLeg.setRotationPoint(2.5F, -5.5F, -6.5F);
			BackTorso.addChild(LDownLeg);

			bone24_r1 = new ModelRenderer(this);
			bone24_r1.setRotationPoint(2.0F, 0.0F, -2.0F);
			LDownLeg.addChild(bone24_r1);
			setRotationAngle(bone24_r1, 0.0F, 0.0F, -0.9599F);

			bone24 = new ModelRenderer(this);
			bone24.setRotationPoint(2.0F, 0.0F, -2.0F);
			LDownLeg.addChild(bone24);
			setRotationAngle(bone24, 0.0F, 0.0F, -0.9599F);
			bone24.setTextureOffset(12, 48).addBox(-2.3192F, -2.9264F, 0.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);
			bone24.setTextureOffset(0, 18).addBox(0.3927F, -0.7544F, 1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(3.5F, 1.6993F, -0.5F);
			LDownLeg.addChild(bone7);

			bone27_r1 = new ModelRenderer(this);
			bone27_r1.setRotationPoint(2.0F, 3.8007F, -3.5F);
			bone7.addChild(bone27_r1);
			setRotationAngle(bone27_r1, 0.0F, -0.6109F, 0.0F);

			bone28_r1 = new ModelRenderer(this);
			bone28_r1.setRotationPoint(2.0F, 1.8007F, -4.5F);
			bone7.addChild(bone28_r1);
			setRotationAngle(bone28_r1, 0.0F, 0.1309F, 0.0F);

			bone26_r1 = new ModelRenderer(this);
			bone26_r1.setRotationPoint(3.0F, 3.8007F, -2.5F);
			bone7.addChild(bone26_r1);
			setRotationAngle(bone26_r1, 0.0F, -1.4835F, 0.0F);

			bone25_r1 = new ModelRenderer(this);
			bone25_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone7.addChild(bone25_r1);
			setRotationAngle(bone25_r1, -0.3054F, 0.0F, -0.3491F);

			bone25 = new ModelRenderer(this);
			bone25.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone7.addChild(bone25);
			setRotationAngle(bone25, -0.3054F, 0.0F, -0.3491F);
			bone25.setTextureOffset(55, 48).addBox(-0.842F, -0.1038F, -0.7174F, 2.0F, 3.0F, 2.0F, 0.0F, false);

			bone26 = new ModelRenderer(this);
			bone26.setRotationPoint(3.0F, 3.8007F, -2.5F);
			bone7.addChild(bone26);
			setRotationAngle(bone26, 0.0F, -1.4835F, 0.0F);
			bone26.setTextureOffset(57, 8).addBox(1.4924F, -1.5F, -1.3257F, 1.0F, 1.0F, 3.0F, 0.0F, false);

			bone28 = new ModelRenderer(this);
			bone28.setRotationPoint(2.0F, 1.8007F, -4.5F);
			bone7.addChild(bone28);
			setRotationAngle(bone28, 0.0F, 0.1309F, 0.0F);
			bone28.setTextureOffset(0, 57).addBox(-1.9611F, 0.5F, 0.4914F, 1.0F, 1.0F, 3.0F, 0.0F, false);

			bone27 = new ModelRenderer(this);
			bone27.setRotationPoint(2.0F, 3.8007F, -3.5F);
			bone7.addChild(bone27);
			setRotationAngle(bone27, 0.0F, -0.6109F, 0.0F);
			bone27.setTextureOffset(49, 35).addBox(0.6472F, -1.5F, -0.8617F, 1.0F, 1.0F, 4.0F, 0.0F, false);

			RDownLeg = new ModelRenderer(this);
			RDownLeg.setRotationPoint(-5.0F, -5.5F, -6.5F);
			BackTorso.addChild(RDownLeg);

			bone53_r1 = new ModelRenderer(this);
			bone53_r1.setRotationPoint(-1.5F, 0.0F, -2.0F);
			RDownLeg.addChild(bone53_r1);
			setRotationAngle(bone53_r1, 0.0F, 0.0F, 0.9599F);

			bone53 = new ModelRenderer(this);
			bone53.setRotationPoint(-1.5F, 0.0F, -2.0F);
			RDownLeg.addChild(bone53);
			setRotationAngle(bone53, 0.0F, 0.0F, 0.9599F);
			bone53.setTextureOffset(0, 43).addBox(-0.6808F, -2.9264F, 0.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);
			bone53.setTextureOffset(6, 9).addBox(-2.3927F, -0.7544F, 1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(-3.0F, 1.6993F, -0.5F);
			RDownLeg.addChild(bone8);

			bone57_r1 = new ModelRenderer(this);
			bone57_r1.setRotationPoint(-2.0F, 1.8007F, -4.5F);
			bone8.addChild(bone57_r1);
			setRotationAngle(bone57_r1, 0.0F, -0.1309F, 0.0F);

			bone56_r1 = new ModelRenderer(this);
			bone56_r1.setRotationPoint(-2.0F, 3.8007F, -3.5F);
			bone8.addChild(bone56_r1);
			setRotationAngle(bone56_r1, 0.0F, 0.6109F, 0.0F);

			bone55_r1 = new ModelRenderer(this);
			bone55_r1.setRotationPoint(-3.0F, 3.8007F, -2.5F);
			bone8.addChild(bone55_r1);
			setRotationAngle(bone55_r1, 0.0F, 1.4835F, 0.0F);

			bone54_r1 = new ModelRenderer(this);
			bone54_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone8.addChild(bone54_r1);
			setRotationAngle(bone54_r1, -0.3054F, 0.0F, 0.3491F);

			bone54 = new ModelRenderer(this);
			bone54.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone8.addChild(bone54);
			setRotationAngle(bone54, -0.3054F, 0.0F, 0.3491F);
			bone54.setTextureOffset(34, 55).addBox(-1.158F, -0.1038F, -0.7174F, 2.0F, 3.0F, 2.0F, 0.0F, false);

			bone55 = new ModelRenderer(this);
			bone55.setRotationPoint(-3.0F, 3.8007F, -2.5F);
			bone8.addChild(bone55);
			setRotationAngle(bone55, 0.0F, 1.4835F, 0.0F);
			bone55.setTextureOffset(55, 35).addBox(-2.4924F, -1.5F, -1.3257F, 1.0F, 1.0F, 3.0F, 0.0F, false);

			bone56 = new ModelRenderer(this);
			bone56.setRotationPoint(-2.0F, 3.8007F, -3.5F);
			bone8.addChild(bone56);
			setRotationAngle(bone56, 0.0F, 0.6109F, 0.0F);
			bone56.setTextureOffset(23, 18).addBox(-1.6472F, -1.5F, -0.8617F, 1.0F, 1.0F, 4.0F, 0.0F, false);

			bone57 = new ModelRenderer(this);
			bone57.setRotationPoint(-2.0F, 1.8007F, -4.5F);
			bone8.addChild(bone57);
			setRotationAngle(bone57, 0.0F, -0.1309F, 0.0F);
			bone57.setTextureOffset(30, 21).addBox(0.9611F, 0.5F, 0.4914F, 1.0F, 1.0F, 3.0F, 0.0F, false);

			Tail1 = new ModelRenderer(this);
			Tail1.setRotationPoint(-1.0F, -5.0F, -3.5F);
			BackTorso.addChild(Tail1);
			setRotationAngle(Tail1, -0.5236F, 0.0F, 0.0F);
			Tail1.setTextureOffset(0, 33).addBox(-3.0F, -2.134F, -1.2679F, 6.0F, 4.0F, 6.0F, 0.0F, false);

			Tail2_r1 = new ModelRenderer(this);
			Tail2_r1.setRotationPoint(0.0F, -0.2453F, 4.365F);
			Tail1.addChild(Tail2_r1);
			setRotationAngle(Tail2_r1, 0.3054F, 0.0F, 0.0F);

			Tail2 = new ModelRenderer(this);
			Tail2.setRotationPoint(0.0F, -0.2453F, 4.365F);
			Tail1.addChild(Tail2);
			setRotationAngle(Tail2, 0.3054F, 0.0F, 0.0F);
			Tail2.setTextureOffset(31, 11).addBox(-2.5F, -1.5516F, -0.3381F, 5.0F, 3.0F, 7.0F, 0.0F, false);

			Tail3_r1 = new ModelRenderer(this);
			Tail3_r1.setRotationPoint(0.0F, 0.3237F, 6.2008F);
			Tail2.addChild(Tail3_r1);
			setRotationAngle(Tail3_r1, 0.1745F, 0.0F, 0.0F);

			Tail3 = new ModelRenderer(this);
			Tail3.setRotationPoint(0.0F, 0.3237F, 6.2008F);
			Tail2.addChild(Tail3);
			setRotationAngle(Tail3, 0.1745F, 0.0F, 0.0F);
			Tail3.setTextureOffset(35, 41).addBox(-2.0F, -1.1939F, -0.3719F, 4.0F, 2.0F, 7.0F, 0.0F, false);

			MiddleTorso = new ModelRenderer(this);
			MiddleTorso.setRotationPoint(-1.0F, 19.0F, -1.0F);

			bone35_r1 = new ModelRenderer(this);
			bone35_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			MiddleTorso.addChild(bone35_r1);
			setRotationAngle(bone35_r1, -0.0873F, 0.0F, 0.0F);

			bone35 = new ModelRenderer(this);
			bone35.setRotationPoint(0.0F, 0.0F, 0.0F);
			MiddleTorso.addChild(bone35);
			setRotationAngle(bone35, -0.0873F, 0.0F, 0.0F);
			bone35.setTextureOffset(0, 0).addBox(-3.5F, -2.6781F, -3.9205F, 7.0F, 6.0F, 12.0F, 0.0F, false);

			Head = new ModelRenderer(this);
			Head.setRotationPoint(-1.0F, 19.0F, -10.0F);

			bone39_r1 = new ModelRenderer(this);
			bone39_r1.setRotationPoint(0.5F, -0.75F, 0.25F);
			Head.addChild(bone39_r1);
			setRotationAngle(bone39_r1, -0.0436F, 0.0F, 0.0F);

			bone32 = new ModelRenderer(this);
			bone32.setRotationPoint(1.0F, 5.0F, 10.0F);
			Head.addChild(bone32);
			bone32.setTextureOffset(18, 39).addBox(-4.0F, -8.0F, -16.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);

			bone33 = new ModelRenderer(this);
			bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone32.addChild(bone33);
			bone33.setTextureOffset(54, 2).addBox(-4.5F, -8.5F, -15.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
			bone33.setTextureOffset(7, 54).addBox(1.5F, -8.5F, -15.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

			bone49 = new ModelRenderer(this);
			bone49.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone33.addChild(bone49);
			bone49.setTextureOffset(26, 3).addBox(1.0F, -10.0F, -14.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			bone49.setTextureOffset(23, 18).addBox(-4.0F, -10.0F, -14.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

			bone39 = new ModelRenderer(this);
			bone39.setRotationPoint(0.5F, -0.75F, 0.25F);
			Head.addChild(bone39);
			setRotationAngle(bone39, -0.0436F, 0.0F, 0.0F);
			bone39.setTextureOffset(26, 0).addBox(-4.0F, 0.6153F, -7.0784F, 7.0F, 3.0F, 7.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			UpperTorso.render(matrixStack, buffer, packedLight, packedOverlay);
			BackTorso.render(matrixStack, buffer, packedLight, packedOverlay);
			MiddleTorso.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.LDownLeg.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Tail1.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Tail3.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Tail2.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RDownLeg.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RUpperLeg.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LUpperLeg.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
