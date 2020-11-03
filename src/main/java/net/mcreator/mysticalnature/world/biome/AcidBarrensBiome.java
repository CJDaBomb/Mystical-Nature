
package net.mcreator.mysticalnature.world.biome;

import net.minecraft.block.material.Material;

@MysticalNatureModElements.ModElement.Tag
public class AcidBarrensBiome extends MysticalNatureModElements.ModElement {

	@ObjectHolder("mystical_nature:acid_barrens")
	public static final CustomBiome biome = null;

	public AcidBarrensBiome(MysticalNatureModElements instance) {
		super(instance, 68);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.01f).scale(0.1f).temperature(0f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.DESERT).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BlackRockBlock.block.getDefaultState(),
							BlackRockBlock.block.getDefaultState(), BlackRockBlock.block.getDefaultState())));

			setRegistryName("acid_barrens");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);

			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITHER_SKELETON, 20, 1, 3));
		}

	}

}
