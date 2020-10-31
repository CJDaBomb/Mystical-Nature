// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelGolem extends EntityModel<Entity> {
	private final ModelRenderer All;
	private final ModelRenderer Body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer Rarm;
	private final ModelRenderer Larm;
	private final ModelRenderer Rleg;
	private final ModelRenderer Lleg;
	private final ModelRenderer Head;

	public ModelGolem() {
		textureWidth = 256;
		textureHeight = 256;

		All = new ModelRenderer(this);
		All.setRotationPoint(16.0F, 24.0F, 0.0F);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		All.addChild(Body);
		Body.setTextureOffset(54, 56).addBox(-26.5F, -22.0F, 4.0F, 21.0F, 9.0F, 15.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-14.0F, -36.0F, 3.5F);
		Body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.5672F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 32).addBox(-12.0F, -5.0F, -8.5F, 20.0F, 25.0F, 14.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-14.5F, -41.5F, -4.0F);
		Body.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.7854F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-17.5F, -7.5F, -9.0F, 31.0F, 15.0F, 17.0F, 0.0F, false);

		Rarm = new ModelRenderer(this);
		Rarm.setRotationPoint(-30.0F, -46.0F, -4.0F);
		All.addChild(Rarm);
		Rarm.setTextureOffset(81, 17).addBox(-10.5F, 31.0F, -7.5F, 15.0F, 15.0F, 15.0F, 0.0F, false);
		Rarm.setTextureOffset(0, 101).addBox(-8.5F, 0.0F, -5.5F, 11.0F, 32.0F, 11.0F, 0.0F, false);

		Larm = new ModelRenderer(this);
		Larm.setRotationPoint(1.0F, -46.0F, -4.0F);
		All.addChild(Larm);
		Larm.setTextureOffset(44, 110).addBox(-6.5F, 0.0F, -5.5F, 11.0F, 32.0F, 11.0F, 0.0F, false);
		Larm.setTextureOffset(81, 17).addBox(-8.5F, 31.0F, -7.5F, 15.0F, 15.0F, 15.0F, 0.0F, false);

		Rleg = new ModelRenderer(this);
		Rleg.setRotationPoint(-21.0F, -15.0F, 12.0F);
		All.addChild(Rleg);
		Rleg.setTextureOffset(88, 110).addBox(-7.0F, -1.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		Lleg = new ModelRenderer(this);
		Lleg.setRotationPoint(-7.0F, -16.0F, 11.0F);
		All.addChild(Lleg);
		Lleg.setTextureOffset(122, 70).addBox(-7.0F, 0.0F, -4.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-15.0F, -43.0F, -7.0F);
		All.addChild(Head);
		Head.setTextureOffset(0, 71).addBox(-9.0F, -8.0F, -14.0F, 15.0F, 14.0F, 16.0F, 0.0F, false);
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.Larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.Lleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Rleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Rarm.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}