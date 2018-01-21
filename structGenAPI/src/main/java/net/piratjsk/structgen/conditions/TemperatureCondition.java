package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

import java.util.Random;

public class TemperatureCondition implements Condition {

    private final double min, max;

    public TemperatureCondition(final double min, final double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean checkFor(final Location loc, final Random random) {
        return loc.getTemperature() >= this.min && loc.getTemperature() <= this.max;
    }
}
