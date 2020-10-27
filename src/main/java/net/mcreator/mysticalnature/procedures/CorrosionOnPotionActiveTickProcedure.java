package net.mcreator.mysticalnature.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mysticalnature.MysticalNatureModVariables;
import net.mcreator.mysticalnature.MysticalNatureModElements;

import java.util.Map;

@MysticalNatureModElements.ModElement.Tag
public class CorrosionOnPotionActiveTickProcedure extends MysticalNatureModElements.ModElement {
	public CorrosionOnPotionActiveTickProcedure(MysticalNatureModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CorrosionOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((MysticalNatureModVariables.corrosionTick) == 70)) {
			if (entity instanceof LivingEntity) {
				DamageSource a = new DamageSource("corrosion").setDamageBypassesArmor();
				((LivingEntity) entity).attackEntityFrom(a, (1 + ((new java.util.Random()).nextInt((int) 2 + 1))));
			}
			MysticalNatureModVariables.corrosionTick = (double) 0;
		} else {
			MysticalNatureModVariables.corrosionTick = (double) ((MysticalNatureModVariables.corrosionTick) + 1);
		}
	}
}
