package net.piratjsk.structgen.bukkit;

import net.piratjsk.structgen.Location;

public class BukkitLocation implements Location {

    private org.bukkit.Location loc;

    public BukkitLocation(org.bukkit.Location loc) {
        this.loc = loc;
    }

    @Override
    public String getBiome() {
        return this.loc.getBlock().getBiome().name();
    }

    @Override
    public String getWorldName() {
        return this.loc.getWorld().getName();
    }

    @Override
    public String getDimension() {
        return this.loc.getWorld().getEnvironment().name();
    }

    @Override
    public double getTemperature() {
        return this.loc.getBlock().getTemperature();
    }

    @Override
    public double getHumidity() {
        return this.loc.getBlock().getHumidity();
    }

    @Override
    public double getX() {
        return this.loc.getX();
    }

    @Override
    public double getY() {
        return this.loc.getY();
    }

    @Override
    public double getZ() {
        return this.loc.getZ();
    }

    @Override
    public int getBlockId() {
        return this.loc.getBlock().getTypeId();
    }

    @Override
    public byte getBlockMeta() {
        return this.loc.getBlock().getData();
    }

    @Override
    public Location getRelative(double x, double y, double z) {
        return new BukkitLocation(this.loc.clone().add(x, y, z));
    }

    @Override
    public Location getRelative(int x, int y, int z) {
        return new BukkitLocation(this.loc.clone().add(x, y, z));
    }

    @Override
    public void setBlock(int blockId, byte blockMeta) {
        this.loc.getBlock().setTypeId(blockId);
        this.loc.getBlock().setTypeIdAndData(blockId,blockMeta,true);
    }

    @Override
    public int getSurfaceLevel() {
        return loc.getWorld().getHighestBlockYAt(this.loc);
    }
}
