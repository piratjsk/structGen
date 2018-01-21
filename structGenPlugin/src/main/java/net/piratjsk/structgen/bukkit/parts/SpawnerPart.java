package net.piratjsk.structgen.bukkit.parts;

import net.piratjsk.structgen.Location;
import net.piratjsk.structgen.parts.Part;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;

public class SpawnerPart implements Part {

    private final int x, y, z;
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
    public void putAt(final Location pointOfOrigin) {
        final World world = Bukkit.getServer().getWorld(pointOfOrigin.getWorldName());
        final org.bukkit.Location loc = new org.bukkit.Location(world, pointOfOrigin.getX(), pointOfOrigin.getY(), pointOfOrigin.getZ());
        loc.getBlock().setType(Material.MOB_SPAWNER);
        final CreatureSpawner spawner = (CreatureSpawner) loc.getBlock();
        spawner.setCreatureType(CreatureType.fromName(this.mobType));
    }
}
