package net.piratjsk.structgen;

public interface Chunk {
	int getX();
	int getZ();
	Location getLocation(double relativeX, double relativeY, double relativeZ);
	Location getLocation(int relativeX, int relativeY, int relativeZ);
}
