
package net.mcreator.mysticalnature.item;

@MysticalNatureModElements.ModElement.Tag
public class CorrosiveEssenceItem extends MysticalNatureModElements.ModElement {

	@ObjectHolder("mystical_nature:corrosive_essence")
	public static final Item block = null;

	public CorrosiveEssenceItem(MysticalNatureModElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64));
			setRegistryName("corrosive_essence");
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
