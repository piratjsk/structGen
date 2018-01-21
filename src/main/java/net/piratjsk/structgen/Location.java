package net.piratjsk.structgen;

public interface Location {
	String getBiome();
	String getWorldName();
	String getDimension();
	double getTemperature();
	double getHumidity();
	double getX();
	double getY();
	double getZ();
	int getBlockId();
	byte getBlockMeta();
	Location getRelative(double x, double y, double z);
	Location getRelative(int x, int y, int z);
	void setBlock(int blockId, byte blockMeta);
	int getSurfaceLevel();
}