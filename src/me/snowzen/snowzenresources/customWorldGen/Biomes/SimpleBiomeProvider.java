package me.snowzen.snowzenresources.customWorldGen.Biomes;

import com.google.common.collect.Lists;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.bukkit.util.noise.SimplexOctaveGenerator;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

public class SimpleBiomeProvider extends BiomeProvider {

    @Nonnull
    @Override
    public Biome getBiome(@Nonnull WorldInfo worldInfo, int x, int y, int z) {
        SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(worldInfo.getSeed()), 6);
        generator.setScale(0.003);

        if (generator.noise(x, z, 1, 1, true) < -0.4) {
        	return Biome.WOODED_BADLANDS;
        }
        else if (generator.noise(x, z, 1, 1, true) < -0.2) {
        	return Biome.ERODED_BADLANDS;
        }
        else if (generator.noise(x, z, 1, 1, true) < 0) {
            return Biome.BADLANDS;
        }
        else if (generator.noise(x, z, 1, 1, true) < 0.1){
        	return Biome.DESERT;
        }
        else if (generator.noise(x, z, 1, 1, true) < 0.3){
        	return Biome.DESERT;
        }
        else if (generator.noise(x, z, 1, 1, true) < 0.7) {
        	return Biome.BASALT_DELTAS;
        }
        else {
            return Biome.WINDSWEPT_GRAVELLY_HILLS;
        }
    }

    @Nonnull
    @Override
    public List<Biome> getBiomes(@Nonnull WorldInfo worldInfo) {
        return Lists.newArrayList(Biome.BADLANDS, Biome.WOODED_BADLANDS, Biome.ERODED_BADLANDS, Biome.DESERT, Biome.BASALT_DELTAS, Biome.WINDSWEPT_GRAVELLY_HILLS);
    }
}
