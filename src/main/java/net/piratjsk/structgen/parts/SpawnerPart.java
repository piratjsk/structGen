package net.piratjsk.structgen.parts;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;

import java.util.Random;

public class SpawnerPart implements Part {

    private int x, y, z;
    private final String mobType;

    public SpawnerPart(final int x, final int y, final int z, final String mobType) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.mobType = mobType;
    }

    @Override
    public double getRelativeX() {
        return this.x;
    }

    @Override
    public double getRelativeY() {
        return this.y;
    }

    @Override
    public double getRelativeZ() {
        return this.z;
    }

    @Override
    public void setRelativeX(double x) {
        this.x = (int) x;
    }

    @Override
    public void setRelativeY(double y) {
        this.y = (int) y;
    }

    @Override
    public void setRelativeZ(double z) {
        this.z = (int) z;
    }

    @Override
    public void putAt(final Location pointOfOrigin, final Random random) {
        final World world = pointOfOrigin.getWorld();
        final Location loc = new Location(world, pointOfOrigin.getX(), pointOfOrigin.getY(), pointOfOrigin.getZ());
        loc.getBlock().setType(Material.MOB_SPAWNER);
        final CreatureSpawner spawner = (CreatureSpawner) loc.getBlock().getState();
        spawner.setCreatureType(CreatureType.valueOf(this.mobType.toUpperCase()));
    }

}
