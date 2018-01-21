package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

import java.util.Random;

public interface Condition {
	boolean checkFor(Location loc, Random random);
}
