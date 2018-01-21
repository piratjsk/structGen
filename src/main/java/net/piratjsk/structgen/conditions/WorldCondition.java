package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

import java.util.Random;

public class WorldCondition implements Condition {

    private final String worldName;

    public WorldCondition(final String worldName) {
        this.worldName = worldName;
    }

    @Override
    public boolean checkFor(final Location loc, final Random random) {
        return loc.getWorldName().equalsIgnoreCase(this.worldName);
    }
}
