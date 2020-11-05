
package net.mcreator.mysticalnature.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.mysticalnature.MysticalNatureModElements;

@MysticalNatureModElements.ModElement.Tag
public class AcidlessMeatItem extends MysticalNatureModElements.ModElement {
	@ObjectHolder("mystical_nature:acidless_meat")
	public static final Item block = null;
	public AcidlessMeatItem(MysticalNatureModElements instance) {
		super(instance, 73);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(9).saturation(14f).meat().build()));
			setRegistryName("acidless_meat");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
