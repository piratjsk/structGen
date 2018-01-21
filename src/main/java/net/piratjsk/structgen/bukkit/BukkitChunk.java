package net.piratjsk.structgen.bukkit;

import net.piratjsk.structgen.Chunk;
import net.piratjsk.structgen.Location;

public class BukkitChunk implements Chunk {

    private final org.bukkit.Chunk chunk;

    public BukkitChunk(org.bukkit.Chunk chunk) {
        this.chunk = chunk;
    }

    @Override
    public int getX() {
        return chunk.getX();
    }

    @Override
    public int getZ() {
        return chunk.getZ();
    }

    @Override
    public Location getLocation(double relativeX, double relativeY, double relativeZ) {
        double x = this.getX()*16+relativeX;
        double z = this.getZ()*16+relativeZ;
        return new BukkitLocation(new org.bukkit.Location(this.chunk.getWorld(), x, relativeY, z));
    }

    @Override
    public Location getLocation(int relativeX, int relativeY, int relativeZ) {
        return new BukkitLocation(this.chunk.getBlock(relativeX, relativeY, relativeZ).getLocation());
    }
}
