
package net.mcreator.mysticalnature.item;

@MysticalNatureModElements.ModElement.Tag
public class CorrosivePebbleItem extends MysticalNatureModElements.ModElement {

	@ObjectHolder("mystical_nature:corrosive_pebble")
	public static final Item block = null;

	public CorrosivePebbleItem(MysticalNatureModElements instance) {
		super(instance, 48);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(64));
			setRegistryName("corrosive_pebble");
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

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

	}

}
