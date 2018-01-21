package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

public class UnderGroundCondition implements Condition {

    private final boolean value;

    public UnderGroundCondition(final boolean value) {
        this.value = value;
    }

    @Override
    public boolean checkFor(Location loc) {
        return value == loc.getY() < loc.getSurfaceLevel();
    }
}
