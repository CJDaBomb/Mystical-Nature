// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelSatyrHorns extends EntityModel<Entity> {
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

	public ModelSatyrHorns() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(bone6);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(3.5F, -7.5F, -1.5F);
		bone6.addChild(bone);
		setRotationAngle(bone, -0.4538F, 0.0F, 0.8727F);
		bone.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(5.1F, -8.6F, 0.4F);
		bone6.addChild(bone2);
		setRotationAngle(bone2, -0.1309F, 0.4363F, -0.6981F);
		bone2.setTextureOffset(0, 8).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(6.25F, -5.25F, 2.05F);
		bone6.addChild(bone4);
		setRotationAngle(bone4, -0.7854F, -0.2182F, 0.0F);
		bone4.setTextureOffset(10, 6).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(6.9F, -3.8F, 0.3F);
		bone6.addChild(bone5);
		setRotationAngle(bone5, -0.0873F, -0.2182F, 0.0F);
		bone5.setTextureOffset(9, 12).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(5.85F, -7.1F, 2.7F);
		bone6.addChild(bone3);
		setRotationAngle(bone3, 0.6545F, 0.2618F, 0.0F);
		bone3.setTextureOffset(10, 6).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(bone7);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(-3.5F, -7.5F, -1.5F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, -0.4538F, 0.0F, -0.8727F);
		bone8.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, true);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-5.1F, -8.6F, 0.4F);
		bone7.addChild(bone9);
		setRotationAngle(bone9, -0.1309F, -0.4363F, 0.6981F);
		bone9.setTextureOffset(0, 8).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, true);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-6.25F, -5.25F, 2.05F);
		bone7.addChild(bone10);
		setRotationAngle(bone10, -0.7854F, 0.2182F, 0.0F);
		bone10.setTextureOffset(10, 6).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-6.9F, -3.8F, 0.3F);
		bone7.addChild(bone11);
		setRotationAngle(bone11, -0.0873F, 0.2182F, 0.0F);
		bone11.setTextureOffset(9, 12).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-5.85F, -7.1F, 2.7F);
		bone7.addChild(bone12);
		setRotationAngle(bone12, 0.6545F, -0.2618F, 0.0F);
		bone12.setTextureOffset(10, 6).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}