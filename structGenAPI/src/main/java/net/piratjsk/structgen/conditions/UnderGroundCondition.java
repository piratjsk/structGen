package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

import java.util.Random;

public class UnderGroundCondition implements Condition {

    private final boolean value;

    public UnderGroundCondition(final boolean value) {
        this.value = value;
    }

    @Override
    public boolean checkFor(final Location loc, final Random random) {
        return value == loc.getY() < loc.getSurfaceLevel();
    }
}
