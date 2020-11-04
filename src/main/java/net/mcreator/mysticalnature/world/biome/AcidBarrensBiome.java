
package net.mcreator.mysticalnature.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;

import net.mcreator.mysticalnature.block.BlackRockBlock;
import net.mcreator.mysticalnature.MysticalNatureModElements;

@MysticalNatureModElements.ModElement.Tag
public class AcidBarrensBiome extends MysticalNatureModElements.ModElement {
	@ObjectHolder("mystical_nature:acid_barrens")
	public static final CustomBiome biome = null;
	public AcidBarrensBiome(MysticalNatureModElements instance) {
		super(instance, 86);
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
			super(new Biome.Builder().downfall(0f).depth(0.01f).scale(0.1f).temperature(2f).precipitation(Biome.RainType.NONE)
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
