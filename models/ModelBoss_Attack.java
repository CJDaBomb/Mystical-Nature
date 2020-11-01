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
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		All.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}