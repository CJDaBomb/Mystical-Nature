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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.FrontLLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.LLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.RLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.FrontRLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}