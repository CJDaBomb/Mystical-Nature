
package net.mcreator.mysticalnature.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.mysticalnature.procedures.AcidMeatFoodEatenProcedure;
import net.mcreator.mysticalnature.MysticalNatureModElements;

import java.util.Map;
import java.util.HashMap;

@MysticalNatureModElements.ModElement.Tag
public class AcidMeatItem extends MysticalNatureModElements.ModElement {
	@ObjectHolder("mystical_nature:acid_meat")
	public static final Item block = null;
	public AcidMeatItem(MysticalNatureModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64)
					.food((new Food.Builder()).hunger(2).saturation(0.3f).setAlwaysEdible().meat().build()));
			setRegistryName("acid_meat");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				AcidMeatFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
