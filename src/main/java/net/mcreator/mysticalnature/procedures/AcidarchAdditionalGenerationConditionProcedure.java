package net.mcreator.mysticalnature.procedures;

@MysticalNatureModElements.ModElement.Tag
public class AcidarchAdditionalGenerationConditionProcedure extends MysticalNatureModElements.ModElement {

	public AcidarchAdditionalGenerationConditionProcedure(MysticalNatureModElements instance) {
		super(instance, 70);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AcidarchAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AcidarchAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AcidarchAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AcidarchAdditionalGenerationCondition!");
			return false;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 0), (int) z)).isSolid())
				&& ((world.getBlockState(new BlockPos((int) (x + 18), (int) (y - 1), (int) z)).isSolid())
						&& ((world.getBlockState(new BlockPos((int) x, (int) (y - 0), (int) (z + 17))).isSolid())
								&& (world.getBlockState(new BlockPos((int) (x + 18), (int) (y - 0), (int) (z + 17))).isSolid()))))) {
			return (true);
		}
		return (false);

	}

}
