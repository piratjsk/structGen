package net.piratjsk.structgen.conditions;

import org.bukkit.Location;

import java.util.Random;

public interface Condition {
	boolean checkFor(Location loc, Random random);
}
