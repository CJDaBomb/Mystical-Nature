// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelHeartlessBoss extends EntityModel<Entity> {
	private final ModelRenderer TUDO;
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r12;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer Arch;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer Arch2;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer Arch3;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r13;
	private final ModelRenderer Arch4;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer Arch5;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer Arch6;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;

	public ModelHeartlessBoss() {
		textureWidth = 256;
		textureHeight = 256;

		TUDO = new ModelRenderer(this);
		TUDO.setRotationPoint(0.0F, 24.0F, 0.0F);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -53.0F, 9.0F);
		TUDO.addChild(Head);
		Head.setTextureOffset(0, 170).addBox(-8.0F, -14.0F, -8.0F, 16.0F, 14.0F, 15.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		TUDO.addChild(Body);
		Body.setTextureOffset(82, 0).addBox(-6.0F, -49.0F, 5.0F, 12.0F, 24.0F, 8.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -26.0F, 10.0F);
		Body.addChild(bone2);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.0F, 1.0F, -1.0F);
		bone2.addChild(cube_r12);
		setRotationAngle(cube_r12, -0.7854F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(0, 145).addBox(-5.0F, -3.1716F, -3.8284F, 9.0F, 18.0F, 6.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-0.25F, 14.5598F, -0.9234F);
		cube_r12.addChild(bone3);
		setRotationAngle(bone3, -0.9599F, 0.0F, 0.0F);
		bone3.setTextureOffset(0, 33).addBox(-3.75F, -2.2359F, -2.1808F, 7.0F, 11.0F, 4.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-0.75F, 8.4785F, 0.0807F);
		bone3.addChild(bone4);
		setRotationAngle(bone4, -0.6109F, 0.0F, 0.0F);
		bone4.setTextureOffset(41, 41).addBox(-2.0F, -1.0492F, -2.7614F, 5.0F, 11.0F, 4.0F, 0.0F, false);

		Arch = new ModelRenderer(this);
		Arch.setRotationPoint(-6.0F, -38.0F, 10.0F);
		TUDO.addChild(Arch);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(20.0F, 0.0F, -17.0F);
		Arch.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.6981F, 0.0F);
		cube_r4.setTextureOffset(74, 20).addBox(-2.0F, -2.0F, -12.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(17.0F, 1.0F, -4.0F);
		Arch.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -0.1309F, 0.0F);
		cube_r5.setTextureOffset(74, 19).addBox(-2.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(14.0F, 0.0F, -3.5F);
		Arch.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.5672F, 0.0F);
		cube_r6.setTextureOffset(104, 87).addBox(-5.0F, -3.0F, -3.5F, 10.0F, 6.0F, 7.0F, 0.0F, false);

		Arch2 = new ModelRenderer(this);
		Arch2.setRotationPoint(5.0F, -37.0F, 9.0F);
		TUDO.addChild(Arch2);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-19.0F, -1.0F, -16.0F);
		Arch2.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, -0.6981F, 0.0F);
		cube_r7.setTextureOffset(74, 27).addBox(-2.0F, -2.0F, -12.0F, 4.0F, 4.0F, 12.0F, 0.0F, true);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-16.0F, 0.0F, -3.0F);
		Arch2.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.1309F, 0.0F);
		cube_r8.setTextureOffset(22, 51).addBox(-3.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, true);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-13.0F, -1.0F, -2.5F);
		Arch2.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -0.5672F, 0.0F);
		cube_r9.setTextureOffset(78, 29).addBox(-5.0F, -3.0F, -3.5F, 10.0F, 6.0F, 7.0F, 0.0F, true);

		Arch3 = new ModelRenderer(this);
		Arch3.setRotationPoint(5.0F, -32.0F, 11.0F);
		TUDO.addChild(Arch3);
		setRotationAngle(Arch3, 0.0F, 0.0F, 0.3054F);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(9.0F, 0.0F, -18.0F);
		Arch3.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.6981F, 0.0F);
		cube_r10.setTextureOffset(74, 14).addBox(-2.0F, -2.0F, -16.0F, 4.0F, 4.0F, 16.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(6.0F, 1.0F, -5.0F);
		Arch3.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, -0.1309F, 0.0F);
		cube_r11.setTextureOffset(72, 19).addBox(-2.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(3.0F, 0.0F, -4.5F);
		Arch3.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.5672F, 0.0F);
		cube_r13.setTextureOffset(79, 25).addBox(-6.0F, -3.0F, -3.5F, 11.0F, 6.0F, 7.0F, 0.0F, false);

		Arch4 = new ModelRenderer(this);
		Arch4.setRotationPoint(-5.0F, -32.0F, 11.0F);
		TUDO.addChild(Arch4);
		setRotationAngle(Arch4, 0.0F, 0.0F, -0.3054F);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-9.0F, 0.0F, -18.0F);
		Arch4.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, -0.6981F, 0.0F);
		cube_r14.setTextureOffset(81, 16).addBox(-2.0F, -2.0F, -16.0F, 4.0F, 4.0F, 16.0F, 0.0F, true);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-6.0F, 1.0F, -5.0F);
		Arch4.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.1309F, 0.0F);
		cube_r15.setTextureOffset(72, 17).addBox(-3.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, true);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-3.0F, 0.0F, -4.5F);
		Arch4.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, -0.5672F, 0.0F);
		cube_r16.setTextureOffset(72, 29).addBox(-5.0F, -3.0F, -3.5F, 11.0F, 6.0F, 7.0F, 0.0F, true);

		Arch5 = new ModelRenderer(this);
		Arch5.setRotationPoint(5.0F, -43.0F, 7.0F);
		TUDO.addChild(Arch5);
		setRotationAngle(Arch5, 0.0F, 0.0F, -0.3054F);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(9.0F, -2.0F, -14.0F);
		Arch5.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.6981F, 0.0F);
		cube_r17.setTextureOffset(70, 15).addBox(-2.0F, -2.0F, -16.0F, 4.0F, 4.0F, 16.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(6.0F, -1.0F, -1.0F);
		Arch5.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, -0.1309F, 0.0F);
		cube_r18.setTextureOffset(53, 48).addBox(-2.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(3.0F, -2.0F, -0.5F);
		Arch5.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.5672F, 0.0F);
		cube_r19.setTextureOffset(83, 19).addBox(-5.0F, -3.0F, -3.5F, 10.0F, 6.0F, 7.0F, 0.0F, false);

		Arch6 = new ModelRenderer(this);
		Arch6.setRotationPoint(-5.0F, -43.0F, 7.0F);
		TUDO.addChild(Arch6);
		setRotationAngle(Arch6, 0.0F, 0.0F, 0.3054F);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-9.0F, -2.0F, -14.0F);
		Arch6.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, -0.6981F, 0.0F);
		cube_r20.setTextureOffset(72, 23).addBox(-2.0F, -2.0F, -16.0F, 4.0F, 4.0F, 16.0F, 0.0F, true);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(-6.0F, -1.0F, -1.0F);
		Arch6.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.1309F, 0.0F);
		cube_r21.setTextureOffset(76, 15).addBox(-3.0F, -3.5F, -15.0F, 5.0F, 5.0F, 15.0F, 0.0F, true);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(-3.0F, -2.0F, -0.5F);
		Arch6.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, -0.5672F, 0.0F);
		cube_r22.setTextureOffset(108, 92).addBox(-5.0F, -3.0F, -3.5F, 10.0F, 6.0F, 7.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		TUDO.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}