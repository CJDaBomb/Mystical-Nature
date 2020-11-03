
package net.mcreator.mysticalnature.block;

import net.minecraft.block.material.Material;

@MysticalNatureModElements.ModElement.Tag
public class BlackDirtBlock extends MysticalNatureModElements.ModElement {

	@ObjectHolder("mystical_nature:black_dirt")
	public static final Block block = null;

	public BlackDirtBlock(MysticalNatureModElements instance) {
		super(instance, 21);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(0.5f, 0.5f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.SHOVEL));

			setRegistryName("black_dirt");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
