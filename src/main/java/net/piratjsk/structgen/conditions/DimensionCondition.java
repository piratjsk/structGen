package net.piratjsk.structgen.conditions;

import org.bukkit.Location;

import java.util.Random;

public class DimensionCondition implements Condition {

    private final String dimension;

    public DimensionCondition(final String dimension) {
        this.dimension = dimension;
    }

    @Override
    public boolean checkFor(final Location loc, final Random random) {
        return loc.getBlock().getBiome().name().equalsIgnoreCase(this.dimension);
    }

}
