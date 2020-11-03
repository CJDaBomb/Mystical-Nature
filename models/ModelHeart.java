// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelHeart extends EntityModel<Entity> {
	private final ModelRenderer Heart;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;

	public ModelHeart() {
		textureWidth = 256;
		textureHeight = 256;

		Heart = new ModelRenderer(this);
		Heart.setRotationPoint(0.0F, 19.0F, 0.0F);
		setRotationAngle(Heart, 0.0F, 0.0F, 2.3126F);
		Heart.setTextureOffset(0, 48).addBox(-5.0F, 2.5F, -2.0F, 3.0F, 5.0F, 4.0F, 0.0F, false);
		Heart.setTextureOffset(41, 10).addBox(-1.5F, 1.5F, -2.0F, 3.0F, 5.0F, 4.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(1.4167F, 0.3676F, 0.0F);
		Heart.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 2.0071F);
		cube_r1.setTextureOffset(41, 0).addBox(-3.5F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-2.5F, 1.5F, 0.5F);
		Heart.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.6545F);
		cube_r2.setTextureOffset(0, 13).addBox(-2.5F, -2.5F, -3.0F, 7.0F, 5.0F, 5.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-0.5F, 0.5F, 0.5F);
		Heart.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.6109F);
		cube_r3.setTextureOffset(0, 0).addBox(-2.5F, -3.5F, -3.5F, 6.0F, 7.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Heart.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Heart.rotateAngleY = f2;
	}
}