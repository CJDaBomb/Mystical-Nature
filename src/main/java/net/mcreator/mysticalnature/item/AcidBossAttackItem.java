
package net.mcreator.mysticalnature.item;

@MysticalNatureModElements.ModElement.Tag
public class AcidBossAttackItem extends MysticalNatureModElements.ModElement {

	@ObjectHolder("mystical_nature:acid_boss_attack")
	public static final Item block = null;

	@ObjectHolder("mystical_nature:entitybulletacid_boss_attack")
	public static final EntityType arrow = null;

	public AcidBossAttackItem(MysticalNatureModElements instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemRanged());
		elements.entities.add(() -> (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("entitybulletacid_boss_attack").setRegistryName("entitybulletacid_boss_attack"));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void init(FMLCommonSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(arrow, renderManager -> new CustomRender(renderManager));
	}

	public static class ItemRanged extends Item {

		public ItemRanged() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxDamage(100));

			setRegistryName("acid_boss_attack");
		}

		@Override
		public UseAction getUseAction(ItemStack stack) {
			return UseAction.BOW;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			entity.setActiveHand(hand);
			return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 72000;
		}

		@Override
		public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
			if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
				ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (true) {

					ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 5, 0);

					itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));

					entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;

					{
						Map<String, Object> $_dependencies = new HashMap<>();

						$_dependencies.put("entity", entity);
						$_dependencies.put("itemstack", itemstack);

						AcidBossAttackRangedItemUsedProcedure.executeProcedure($_dependencies);
					}

				}
			}
		}

	}

	@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
	public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {

		public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			super(arrow, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
			super(type, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
			super(type, x, y, z, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
			super(type, entity, world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack getItem() {
			return new ItemStack(CorrosivePebbleItem.block, (int) (1));
		}

		@Override
		protected ItemStack getArrowStack() {
			return null;
		}

		@Override
		protected void arrowHit(LivingEntity entity) {
			super.arrowHit(entity);
			entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
		}

		@Override
		public void tick() {
			super.tick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			World world = this.world;
			Entity entity = this.getShooter();
			if (this.inGround) {
				this.remove();
			}
		}

	}

	public static class CustomRender extends EntityRenderer<ArrowCustomEntity> {
		private static final ResourceLocation texture = new ResourceLocation("mystical_nature:textures/acidbossattack.png");

		public CustomRender(EntityRendererManager renderManager) {
			super(renderManager);
		}

		@Override
		public void render(ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
				int packedLightIn) {
			IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
			EntityModel model = new ModelBoss_Attack();
			model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
			matrixStackIn.pop();

			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

		@Override
		public ResourceLocation getEntityTexture(ArrowCustomEntity entity) {
			return texture;
		}
	}

	// Made with Blockbench 3.7.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	public static class ModelBoss_Attack extends EntityModel<Entity> {
		private final ModelRenderer All;

		public ModelBoss_Attack() {
			textureWidth = 16;
			textureHeight = 16;

			All = new ModelRenderer(this);
			All.setRotationPoint(0.0F, 20.0F, 0.0F);
			All.setTextureOffset(0, 0).addBox(3.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(2.5F, -2.5F, -2.5F, 1.0F, 5.0F, 5.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(-3.5F, -2.5F, -2.5F, 1.0F, 5.0F, 5.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(-2.5F, -2.5F, -3.5F, 5.0F, 5.0F, 1.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(-2.5F, -2.5F, 2.5F, 5.0F, 5.0F, 1.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(-2.5F, -3.5F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(-2.5F, 1.5F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(2.5F, -2.5F, -2.5F, 1.0F, 5.0F, 5.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(-2.0F, 3.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
			All.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
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

		}
	}

	public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
		entityarrow.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setIsCritical(false);
		entityarrow.setDamage(damage);
		entityarrow.setKnockbackStrength(knockback);
		world.addEntity(entityarrow);

		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
				1f / (random.nextFloat() * 0.5f + 1) + (power / 2));

		return entityarrow;
	}

	public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
		double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
		double d1 = target.getPosX() - entity.getPosX();
		double d3 = target.getPosZ() - entity.getPosZ();
		entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1f * 2, 12.0F);

		entityarrow.setSilent(true);
		entityarrow.setDamage(5);
		entityarrow.setKnockbackStrength(0);
		entityarrow.setIsCritical(false);
		entity.world.addEntity(entityarrow);

		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
				1f / (new Random().nextFloat() * 0.5f + 1));

		return entityarrow;
	}

}
