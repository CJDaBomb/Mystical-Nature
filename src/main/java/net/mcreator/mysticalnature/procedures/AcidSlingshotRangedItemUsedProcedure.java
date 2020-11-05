package net.mcreator.mysticalnature.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mysticalnature.MysticalNatureModElements;

import java.util.Map;

@MysticalNatureModElements.ModElement.Tag
public class AcidSlingshotRangedItemUsedProcedure extends MysticalNatureModElements.ModElement {
	public AcidSlingshotRangedItemUsedProcedure(MysticalNatureModElements instance) {
		super(instance, 88);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AcidSlingshotRangedItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure AcidSlingshotRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 25);
	}
}
