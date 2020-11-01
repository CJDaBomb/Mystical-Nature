
package net.mcreator.mysticalnature.block;

import net.minecraft.block.material.Material;

@MysticalNatureModElements.ModElement.Tag
public class PolishedBlackStoneBlock extends MysticalNatureModElements.ModElement {

	@ObjectHolder("mystical_nature:polished_black_stone")
	public static final Block block = null;

	public PolishedBlackStoneBlock(MysticalNatureModElements instance) {
		super(instance, 25);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 6f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("polished_black_stone");
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
