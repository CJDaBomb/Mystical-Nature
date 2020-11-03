// Made with Blockbench 3.7.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelBlackRockAmmo extends EntityModel<Entity> {
	private final ModelRenderer bone;

	public ModelBlackRockAmmo() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-2.0F, 23.0F, -2.0F);
		bone.setTextureOffset(0, 0).addBox(1.5F, -2.5F, 3.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(1.5F, -3.5F, 1.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(1.0F, -3.0F, 1.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(0.5F, -2.5F, 1.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(3.5F, -2.5F, 1.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(1.5F, -0.5F, 1.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(1.5F, -2.5F, 0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}