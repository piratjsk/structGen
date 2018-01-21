package net.piratjsk.structgen.conditions;

import org.bukkit.Location;

import java.util.Random;

public class WorldCondition implements Condition {

    private final String worldName;

    public WorldCondition(final String worldName) {
        this.worldName = worldName;
    }

    @Override
    public boolean checkFor(final Location loc, final Random random) {
        return loc.getWorld().getName().equalsIgnoreCase(this.worldName);
    }

}
