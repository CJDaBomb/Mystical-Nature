
package net.mcreator.mysticalnature.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;

import net.mcreator.mysticalnature.block.BlackDirtBlock;
import net.mcreator.mysticalnature.MysticalNatureModElements;

@MysticalNatureModElements.ModElement.Tag
public class BloodyThornsValleyBiome extends MysticalNatureModElements.ModElement {
	@ObjectHolder("mystical_nature:bloody_thorns_valley")
	public static final CustomBiome biome = null;
	public BloodyThornsValleyBiome(MysticalNatureModElements instance) {
		super(instance, 145);
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
			super(new Biome.Builder().downfall(0f).depth(0.5f).scale(0.2f).temperature(1f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.PLAINS).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BlackDirtBlock.block.getDefaultState(),
							BlackDirtBlock.block.getDefaultState(), BlackDirtBlock.block.getDefaultState())));
			setRegistryName("bloody_thorns_valley");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
		}
	}
}
