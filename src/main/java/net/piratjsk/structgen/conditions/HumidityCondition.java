package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

import java.util.Random;

public class HumidityCondition implements Condition {

    private final double min, max;

    public HumidityCondition(final double min, final double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean checkFor(final Location loc, final Random random) {
        return loc.getHumidity() >= this.min && loc.getHumidity() <= this.max;
    }
}
