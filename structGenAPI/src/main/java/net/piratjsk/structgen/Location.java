package net.piratjsk.structgen;

public interface Location {
	String getBiome();
	String getWorldName();
	String getDimension();
	int getTemperature();
	int getHumidity();
	double getX();
	double getY();
	double getZ();
	int getBlockId();
	int getBlockMeta();
	Location getRelative(double x, double y, double z);
	Location getRelative(int x, int y, int z);
	void setBlock(int blockId, int blockMeta);
	int getSurfaceLevel();
}