package net.piratjsk.structgen.algorithms;

import org.bukkit.Chunk;
import org.bukkit.Location;

import java.util.Random;

public interface Algorithm {
	Location findLocation(Chunk chunk, Random random);
}
