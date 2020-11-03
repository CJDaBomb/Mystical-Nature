package net.mcreator.mysticalnature.procedures;

@MysticalNatureModElements.ModElement.Tag
public class AcidMeatFoodEatenProcedure extends MysticalNatureModElements.ModElement {

	public AcidMeatFoodEatenProcedure(MysticalNatureModElements instance) {
		super(instance, 61);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AcidMeatFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(CorrosionPotion.potion, (int) 10, (int) 1));

	}

}
