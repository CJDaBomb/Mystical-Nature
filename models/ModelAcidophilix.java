// Made with Blockbench 3.7.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelAcidophilix extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_leg;

	public ModelAcidophilix() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 1.0F, -4.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -6.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-3.0F, 1.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(0.0F, 1.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-1.0F, 1.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(2.0F, 1.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(8, 53).addBox(0.5F, -7.5F, -6.5F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(10, 48).addBox(-4.5F, -5.5F, -1.5F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-1.0F, 2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(16, 50).addBox(-1.5F, -6.5F, 0.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(13, 50).addBox(2.6F, -4.5F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 7.0F, -2.0F);
		setRotationAngle(body, 0.3491F, 0.0F, 0.0F);
		body.setTextureOffset(16, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(15, 46).addBox(-3.0F, -4.342F, -2.9397F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(15, 47).addBox(-2.0F, 1.0405F, -2.7704F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(6, 54).addBox(-1.0F, -2.4626F, -3.6237F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(9, 48).addBox(-3.0F, -4.658F, 1.9397F, 5.0F, 6.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(17, 50).addBox(0.0F, 0.2214F, 1.2557F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(4.0F, 2.0F, -4.0F);
		left_arm.setTextureOffset(40, 16).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		left_arm.setTextureOffset(9, 50).addBox(1.5F, -0.5F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		left_arm.setTextureOffset(12, 49).addBox(2.5F, 6.5F, 0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		left_arm.setTextureOffset(12, 49).addBox(2.6F, 1.5F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		left_arm.setTextureOffset(13, 51).addBox(0.5F, 8.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		left_arm.setTextureOffset(13, 51).addBox(1.5F, 7.5F, -2.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-4.0F, 2.0F, -4.0F);
		right_arm.setTextureOffset(40, 16).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		right_arm.setTextureOffset(12, 49).addBox(-4.5F, 9.5F, -2.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		right_arm.setTextureOffset(12, 49).addBox(-1.5F, -0.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		right_arm.setTextureOffset(19, 50).addBox(-4.5F, 3.5F, 0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		right_arm.setTextureOffset(13, 51).addBox(-1.5F, 5.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(2.1F, 12.0F, 0.0F);
		left_leg.setTextureOffset(0, 16).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		left_leg.setTextureOffset(3, 52).addBox(-0.6F, 2.5F, -2.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		left_leg.setTextureOffset(3, 52).addBox(-1.6F, 5.5F, -0.4F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		left_leg.setTextureOffset(12, 49).addBox(0.4F, 8.5F, 0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		left_leg.setTextureOffset(12, 49).addBox(-1.6F, 5.5F, -2.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-2.1F, 12.0F, 0.0F);
		right_leg.setTextureOffset(0, 16).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		right_leg.setTextureOffset(8, 51).addBox(-2.4F, 9.5F, -2.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		right_leg.setTextureOffset(3, 52).addBox(-2.4F, 1.5F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		right_leg.setTextureOffset(12, 49).addBox(-2.4F, 6.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		right_leg.setTextureOffset(12, 49).addBox(-1.4F, 5.5F, -2.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		right_leg.setTextureOffset(12, 49).addBox(-0.4F, 3.5F, 0.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}