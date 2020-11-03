
package net.mcreator.mysticalnature.item;

@MysticalNatureModElements.ModElement.Tag
public class AcidmanderSkinItem extends MysticalNatureModElements.ModElement {

	@ObjectHolder("mystical_nature:acidmander_skin")
	public static final Item block = null;

	public AcidmanderSkinItem(MysticalNatureModElements instance) {
		super(instance, 39);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64));
			setRegistryName("acidmander_skin");
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
