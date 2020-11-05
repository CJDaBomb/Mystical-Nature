// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelBloodSpider extends EntityModel<Entity> {
	private final ModelRenderer left_leg1;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer left_leg2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer left_leg3;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer right_leg1;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer right_leg2;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer right_leg3;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer right_leg4;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer Head;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r15;

	public ModelBloodSpider() {
		textureWidth = 32;
		textureHeight = 32;

		left_leg1 = new ModelRenderer(this);
		left_leg1.setRotationPoint(0.5F, 22.0833F, -2.3F);
		setRotationAngle(left_leg1, 0.0F, 0.4363F, 0.0F);
		left_leg1.setTextureOffset(3, 2).addBox(4.3642F, 1.9167F, -1.0448F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(2.7915F, -0.8333F, 0.3615F);
		left_leg1.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 1.1781F);
		cube_r1.setTextureOffset(15, 17).addBox(-0.8383F, -0.3904F, -1.4063F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(1.6415F, -1.0833F, 0.3615F);
		left_leg1.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.6981F);
		cube_r2.setTextureOffset(0, 13).addBox(-0.6763F, 0.2717F, -1.4063F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		left_leg2 = new ModelRenderer(this);
		left_leg2.setRotationPoint(0.5F, 22.0F, -2.0F);
		left_leg2.setTextureOffset(2, 15).addBox(3.8F, 2.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(2.65F, -0.75F, -0.5F);
		left_leg2.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 1.1781F);
		cube_r3.setTextureOffset(18, 15).addBox(-1.0F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(1.5F, -1.0F, -0.5F);
		left_leg2.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -0.6981F);
		cube_r4.setTextureOffset(0, 16).addBox(0.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		left_leg3 = new ModelRenderer(this);
		left_leg3.setRotationPoint(0.4167F, 22.0833F, -2.5F);
		setRotationAngle(left_leg3, 0.0F, -0.4363F, 0.0F);
		left_leg3.setTextureOffset(3, 1).addBox(4.4095F, 1.9167F, -0.2816F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(2.8369F, -0.8333F, 1.1247F);
		left_leg3.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 1.1781F);
		cube_r5.setTextureOffset(16, 13).addBox(-0.8383F, -0.3904F, -1.4063F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(1.6869F, -1.0833F, 1.1247F);
		left_leg3.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.6981F);
		cube_r6.setTextureOffset(0, 12).addBox(-0.6763F, 0.2717F, -1.4063F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		right_leg1 = new ModelRenderer(this);
		right_leg1.setRotationPoint(0.5F, 22.0F, -2.75F);
		setRotationAngle(right_leg1, 0.0F, -0.4363F, 0.0F);
		right_leg1.setTextureOffset(10, 12).addBox(-5.2837F, 2.0F, -0.4711F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-2.7111F, -0.75F, 0.9352F);
		right_leg1.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -1.1781F);
		cube_r7.setTextureOffset(15, 18).addBox(-3.1617F, -0.3904F, -1.4063F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-1.5611F, -1.0F, 0.9352F);
		right_leg1.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, 0.6981F);
		cube_r8.setTextureOffset(0, 14).addBox(-1.3237F, 0.2717F, -1.4063F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		right_leg2 = new ModelRenderer(this);
		right_leg2.setRotationPoint(0.5F, 24.0F, -2.0F);
		right_leg2.setTextureOffset(10, 13).addBox(-4.8F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-2.65F, -2.75F, -0.5F);
		right_leg2.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, -1.1781F);
		cube_r9.setTextureOffset(18, 14).addBox(-3.0F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-1.5F, -3.0F, -0.5F);
		right_leg2.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, 0.6981F);
		cube_r10.setTextureOffset(0, 15).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		right_leg3 = new ModelRenderer(this);
		right_leg3.setRotationPoint(0.3833F, 22.0833F, -2.3F);
		setRotationAngle(right_leg3, 0.0F, 0.4363F, 0.0F);
		right_leg3.setTextureOffset(3, 0).addBox(-5.1437F, 1.9167F, -0.3783F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-2.5711F, -0.8333F, 1.028F);
		right_leg3.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -1.1781F);
		cube_r11.setTextureOffset(16, 12).addBox(-3.1617F, -0.3904F, -1.4063F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-1.4211F, -1.0833F, 1.028F);
		right_leg3.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, 0.6981F);
		cube_r12.setTextureOffset(0, 5).addBox(-1.3237F, 0.2717F, -1.4063F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		right_leg4 = new ModelRenderer(this);
		right_leg4.setRotationPoint(0.5F, 22.0F, -2.75F);
		setRotationAngle(right_leg4, 0.0F, -0.4363F, 0.0F);
		right_leg4.setTextureOffset(3, 3).addBox(-5.2837F, 2.0F, -0.4711F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-2.7111F, -0.75F, 0.9352F);
		right_leg4.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -1.1781F);
		cube_r13.setTextureOffset(10, 16).addBox(-3.1617F, -0.3904F, -1.4063F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-1.5611F, -1.0F, 0.9352F);
		right_leg4.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, 0.6981F);
		cube_r14.setTextureOffset(0, 4).addBox(-1.3237F, 0.2717F, -1.4063F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.5F, 22.5F, -4.0F);
		Head.setTextureOffset(11, 12).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(0, 2).addBox(-1.5F, 0.1F, -3.5F, 1.0F, 0.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(0.5F, 0.1F, -3.5F, 1.0F, 0.0F, 2.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 12).addBox(-1.0F, -3.0F, -4.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(0.5F, -3.55F, 2.4F);
		bb_main.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.4363F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(0, 0).addBox(-3.5F, -3.0F, -3.0F, 7.0F, 6.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		left_leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg4.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.right_leg1.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.right_leg2.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.left_leg1.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.left_leg2.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.left_leg3.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.right_leg3.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}