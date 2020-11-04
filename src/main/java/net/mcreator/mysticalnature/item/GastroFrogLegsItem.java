
package net.mcreator.mysticalnature.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.mysticalnature.MysticalNatureModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MysticalNatureModElements.ModElement.Tag
public class GastroFrogLegsItem extends MysticalNatureModElements.ModElement {
	@ObjectHolder("mystical_nature:gastro_frog_legs_helmet")
	public static final Item helmet = null;
	@ObjectHolder("mystical_nature:gastro_frog_legs_chestplate")
	public static final Item body = null;
	@ObjectHolder("mystical_nature:gastro_frog_legs_leggings")
	public static final Item legs = null;
	@ObjectHolder("mystical_nature:gastro_frog_legs_boots")
	public static final Item boots = null;
	public GastroFrogLegsItem(MysticalNatureModElements instance) {
		super(instance, 64);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "gastro_frog_legs";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new ModelGastroFrogLegs().L;
				armorModel.bipedRightLeg = new ModelGastroFrogLegs().R;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "mystical_nature:textures/models/armor/gastrofroglegs_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("gastro_frog_legs_boots"));
	}
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
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			R.render(matrixStack, buffer, packedLight, packedOverlay);
			L.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
