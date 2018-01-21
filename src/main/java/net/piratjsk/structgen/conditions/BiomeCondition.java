package net.piratjsk.structgen.conditions;

import org.bukkit.Location;

import java.util.Random;

public class BiomeCondition implements Condition {

    private final String biome;

    public BiomeCondition(final String biome) {
        this.biome = biome;
    }

    @Override
    public boolean checkFor(final Location loc, final Random random) {
        return loc.getBlock().getBiome().name().equalsIgnoreCase(this.biome);
    }

}
