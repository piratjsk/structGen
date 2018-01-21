package net.piratjsk.structgen.algorithms;

import net.piratjsk.structgen.Chunk;
import net.piratjsk.structgen.Location;

import java.util.Random;

public interface Algorithm {
	Location findLocation(Chunk chunk, Random random);
}
