package net.piratjsk.structgen.algorithms;

import net.piratjsk.structgen.Chunk;
import net.piratjsk.structgen.Location;

public interface Algorithm {
	Location findLocation(Chunk chunk);
}