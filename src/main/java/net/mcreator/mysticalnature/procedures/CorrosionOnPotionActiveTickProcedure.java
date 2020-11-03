package net.mcreator.mysticalnature.procedures;

import net.mcreator.mysticalnature.MysticalNatureModVariables;
import net.mcreator.mysticalnature.MysticalNatureModElements;

import java.util.Map;

@MysticalNatureModElements.ModElement.Tag
public class CorrosionOnPotionActiveTickProcedure extends MysticalNatureModElements.ModElement {
	public CorrosionOnPotionActiveTickProcedure(MysticalNatureModElements instance) {
		super(instance, 54);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (((MysticalNatureModVariables.corrosionTick) == 70)) {
			MysticalNatureModVariables.corrosionTick = (double) 0;
		} else {
			MysticalNatureModVariables.corrosionTick = (double) ((MysticalNatureModVariables.corrosionTick) + 1);
		}
	}
}
