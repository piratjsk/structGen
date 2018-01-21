package net.piratjsk.structgen.conditions;
import org.bukkit.Location;

import java.util.Random;

public class TemperatureCondition implements Condition {

    private final double min, max;

    public TemperatureCondition(final double min, final double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean checkFor(final Location loc, final Random random) {
        final double temperature = loc.getBlock().getTemperature();
        return temperature >= this.min && temperature <= this.max;
    }

}
