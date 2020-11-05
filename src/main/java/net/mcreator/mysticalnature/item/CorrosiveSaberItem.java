
package net.mcreator.mysticalnature.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.mysticalnature.MysticalNatureModElements;

@MysticalNatureModElements.ModElement.Tag
public class CorrosiveSaberItem extends MysticalNatureModElements.ModElement {
	@ObjectHolder("mystical_nature:corrosive_saber")
	public static final Item block = null;
	public CorrosiveSaberItem(MysticalNatureModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1200;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CorrosiveIngotItem.block, (int) (1)));
			}
		}, 3, -2.2f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("corrosive_saber"));
	}
}
