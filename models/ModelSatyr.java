// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelSatyr extends EntityModel<Entity> {
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
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer body;
	private final ModelRenderer bone15;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_leg;
	private final ModelRenderer left_leg_r1;
	private final ModelRenderer left_leg2;
	private final ModelRenderer left_leg_r2;

	public ModelSatyr() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(bone6);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(3.5F, -7.5F, -1.5F);
		bone6.addChild(bone);
		setRotationAngle(bone, -0.4538F, 0.0F, 0.8727F);
		bone.setTextureOffset(44, 12).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(5.1F, -8.6F, 0.4F);
		bone6.addChild(bone2);
		setRotationAngle(bone2, -0.1309F, 0.4363F, -0.6981F);
		bone2.setTextureOffset(28, 12).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(6.25F, -5.25F, 2.05F);
		bone6.addChild(bone4);
		setRotationAngle(bone4, -0.7854F, -0.2182F, 0.0F);
		bone4.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(6.9F, -3.8F, 0.3F);
		bone6.addChild(bone5);
		setRotationAngle(bone5, -0.0873F, -0.2182F, 0.0F);
		bone5.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(5.85F, -7.1F, 2.7F);
		bone6.addChild(bone3);
		setRotationAngle(bone3, 0.6545F, 0.2618F, 0.0F);
		bone3.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(bone7);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(-3.5F, -7.5F, -1.5F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, -0.4538F, 0.0F, -0.8727F);
		bone8.setTextureOffset(45, 12).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, true);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-5.1F, -8.6F, 0.4F);
		bone7.addChild(bone9);
		setRotationAngle(bone9, -0.1309F, -0.4363F, 0.6981F);
		bone9.setTextureOffset(28, 12).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, true);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-6.25F, -5.25F, 2.05F);
		bone7.addChild(bone10);
		setRotationAngle(bone10, -0.7854F, 0.2182F, 0.0F);
		bone10.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-6.9F, -3.8F, 0.3F);
		bone7.addChild(bone11);
		setRotationAngle(bone11, -0.0873F, 0.2182F, 0.0F);
		bone11.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-5.85F, -7.1F, 2.7F);
		bone7.addChild(bone12);
		setRotationAngle(bone12, 0.6545F, -0.2618F, 0.0F);
		bone12.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(4.5F, -3.6F, -1.0F);
		head.addChild(bone13);
		setRotationAngle(bone13, 0.0F, 0.0F, -0.6109F);
		bone13.setTextureOffset(16, 47).addBox(-0.5491F, -1.7785F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(-4.5F, -3.6F, -1.0F);
		head.addChild(bone14);
		setRotationAngle(bone14, 0.0F, 0.0F, 0.6109F);
		bone14.setTextureOffset(16, 47).addBox(-0.4509F, -1.7785F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, true);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(-1.5F, -0.9F, -4.6F);
		head.addChild(bone16);
		setRotationAngle(bone16, 1.0472F, 0.0F, 0.0F);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(1.5F, -0.9F, -4.6F);
		head.addChild(bone17);
		setRotationAngle(bone17, 1.0472F, 0.0F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.setTextureOffset(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 12.1F, 2.5F);
		body.addChild(bone15);
		setRotationAngle(bone15, 0.6981F, 0.0F, 0.0F);
		bone15.setTextureOffset(21, 45).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		left_arm.setTextureOffset(24, 24).addBox(9.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
		right_arm.setTextureOffset(24, 24).addBox(-13.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(2.1F, 12.5F, 0.0F);
		setRotationAngle(left_leg, -0.2967F, 0.0F, 0.0F);

		left_leg_r1 = new ModelRenderer(this);
		left_leg_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		left_leg.addChild(left_leg_r1);
		setRotationAngle(left_leg_r1, -0.2967F, 0.0F, 0.0F);
		left_leg_r1.setTextureOffset(32, 48).addBox(-1.9F, 6.9519F, -0.2381F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		left_leg_r1.setTextureOffset(20, 48).addBox(-1.9F, 4.9519F, 1.7619F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		left_leg_r1.setTextureOffset(16, 40).addBox(-1.9F, -1.0481F, -2.2381F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		left_leg2 = new ModelRenderer(this);
		left_leg2.setRotationPoint(-2.1F, 12.5F, 0.0F);
		setRotationAngle(left_leg2, -0.2967F, 0.0F, 0.0F);

		left_leg_r2 = new ModelRenderer(this);
		left_leg_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		left_leg2.addChild(left_leg_r2);
		setRotationAngle(left_leg_r2, -0.2967F, 0.0F, 0.0F);
		left_leg_r2.setTextureOffset(32, 48).addBox(-1.9F, 6.9519F, -0.2381F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		left_leg_r2.setTextureOffset(20, 48).addBox(-1.9F, 4.9519F, 1.7619F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		left_leg_r2.setTextureOffset(16, 40).addBox(-1.9F, -1.0481F, -2.2381F, 4.0F, 8.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}