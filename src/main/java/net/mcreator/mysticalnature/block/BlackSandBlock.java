
package net.mcreator.mysticalnature.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.mysticalnature.MysticalNatureModElements;

import java.util.List;
import java.util.Collections;

@MysticalNatureModElements.ModElement.Tag
public class BlackSandBlock extends MysticalNatureModElements.ModElement {
	@ObjectHolder("mystical_nature:ancient_sand")
	public static final Block block = null;
	public BlackSandBlock(MysticalNatureModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends FallingBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.SAND).sound(SoundType.SAND).hardnessAndResistance(0.5f, 0.5f).lightValue(0).harvestLevel(1)
					.harvestTool(ToolType.SHOVEL));
			setRegistryName("ancient_sand");
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
