// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelGastroFrogLegs extends EntityModel<Entity> {
	private final ModelRenderer R;
	private final ModelRenderer L;

	public ModelGastroFrogLegs() {
		textureWidth = 64;
		textureHeight = 32;

		R = new ModelRenderer(this);
		R.setRotationPoint(2.0F, 12.0F, 0.0F);
		R.setTextureOffset(16, 25).addBox(-6.5F, 10.3F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		R.setTextureOffset(26, 25).addBox(-6.5F, 11.9F, -7.5F, 5.0F, 0.0F, 5.0F, 0.0F, false);

		L = new ModelRenderer(this);
		L.setRotationPoint(2.0F, 12.0F, 0.0F);
		L.setTextureOffset(16, 25).addBox(-2.5F, 10.3F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		L.setTextureOffset(26, 25).addBox(-2.5F, 11.9F, -7.5F, 5.0F, 0.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		R.render(matrixStack, buffer, packedLight, packedOverlay);
		L.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}