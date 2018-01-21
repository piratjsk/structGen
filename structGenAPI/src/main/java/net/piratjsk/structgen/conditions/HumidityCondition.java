package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

public class HumidityCondition implements Condition {

    private final double min, max;

    public HumidityCondition(final double min, final double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean checkFor(final Location loc) {
        return loc.getHumidity() >= this.min && loc.getHumidity() <= this.max;
    }
}
