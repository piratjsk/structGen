package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

public class HeightCondition implements Condition {

    private final int min, max;

    public HeightCondition(final int min, final int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean checkFor(final Location loc) {
        return loc.getY() >= this.min && loc.getY() <= this.max;
    }
}
