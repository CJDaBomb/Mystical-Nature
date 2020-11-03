
package net.mcreator.mysticalnature.item;

@MysticalNatureModElements.ModElement.Tag
public class AcidBallItem extends MysticalNatureModElements.ModElement {

	@ObjectHolder("mystical_nature:acid_ball")
	public static final Item block = null;

	public AcidBallItem(MysticalNatureModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64));
			setRegistryName("acid_ball");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
