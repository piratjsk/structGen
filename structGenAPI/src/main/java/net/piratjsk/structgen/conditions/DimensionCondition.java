package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

public class DimensionCondition implements Condition {

    private final String dimension;

    public DimensionCondition(final String dimension) {
        this.dimension = dimension;
    }

    @Override
    public boolean checkFor(final Location loc) {
        return loc.getDimension().equalsIgnoreCase(this.dimension);
    }
}