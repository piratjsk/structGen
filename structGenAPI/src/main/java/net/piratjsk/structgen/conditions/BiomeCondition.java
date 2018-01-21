package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

import java.util.Random;

public class BiomeCondition implements Condition {

    private final String biome;

    public BiomeCondition(final String biome) {
        this.biome = biome;
    }

    @Override
    public boolean checkFor(final Location loc, final Random random) {
        return loc.getBiome().equalsIgnoreCase(this.biome);
    }
}
