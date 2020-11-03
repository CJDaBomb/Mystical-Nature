package net.mcreator.mysticalnature.procedures;

@MysticalNatureModElements.ModElement.Tag
public class TinyBlackSpikesEntityCollidesInTheBlockProcedure extends MysticalNatureModElements.ModElement {

	public TinyBlackSpikesEntityCollidesInTheBlockProcedure(MysticalNatureModElements instance) {
		super(instance, 100);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TinyBlackSpikesEntityCollidesInTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((entity instanceof PlayerEntity)) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 2);
		}

	}

}
