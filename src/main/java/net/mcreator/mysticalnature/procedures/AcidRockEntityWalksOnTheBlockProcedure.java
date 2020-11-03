package net.mcreator.mysticalnature.procedures;

@MysticalNatureModElements.ModElement.Tag
public class AcidRockEntityWalksOnTheBlockProcedure extends MysticalNatureModElements.ModElement {

	public AcidRockEntityWalksOnTheBlockProcedure(MysticalNatureModElements instance) {
		super(instance, 112);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AcidRockEntityWalksOnTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((entity instanceof PlayerEntity)) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 2);
		}

	}

}
