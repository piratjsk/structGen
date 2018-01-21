package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

public interface Condition {
	boolean checkFor(Location loc);
}