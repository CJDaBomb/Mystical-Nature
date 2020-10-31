
package net.mcreator.mysticalnature.block;

import net.minecraft.block.material.Material;

@MysticalNatureModElements.ModElement.Tag
public class GhostwoodLeavesBlock extends MysticalNatureModElements.ModElement {

	@ObjectHolder("mystical_nature:ghostwood_leaves")
	public static final Block block = null;

	public GhostwoodLeavesBlock(MysticalNatureModElements instance) {
		super(instance, 19);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends LeavesBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.5499999999999999f, 4f).lightValue(0)
							.notSolid());

			setRegistryName("ghostwood_leaves");
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
