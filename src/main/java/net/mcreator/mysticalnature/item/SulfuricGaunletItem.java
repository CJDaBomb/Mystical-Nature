
package net.mcreator.mysticalnature.item;

@MysticalNatureModElements.ModElement.Tag
public class SulfuricGaunletItem extends MysticalNatureModElements.ModElement {

	@ObjectHolder("mystical_nature:sulfuric_gaunlet")
	public static final Item block = null;

	public SulfuricGaunletItem(MysticalNatureModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("sulfuric_gaunlet"));
	}

}