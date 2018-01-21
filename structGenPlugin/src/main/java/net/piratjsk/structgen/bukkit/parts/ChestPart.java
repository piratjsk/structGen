package net.piratjsk.structgen.bukkit.parts;

import net.piratjsk.structgen.Location;
import net.piratjsk.structgen.parts.Part;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Chest;

import java.util.Random;

public class ChestPart implements Part {

    private int x, y, z;

    public ChestPart(final int x, final int y, final int z, final String lootTable) {
        this.x = x;
        this.y = y;
        this.z = z;
        // TODO: implement loot tables
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
        final World world = Bukkit.getServer().getWorld(pointOfOrigin.getWorldName());
        final org.bukkit.Location loc = new org.bukkit.Location(world, pointOfOrigin.getX(), pointOfOrigin.getY(), pointOfOrigin.getZ());
        loc.getBlock().setType(Material.CHEST);
        Chest chest = (Chest) loc.getBlock().getState();

        // TODO: generate items based on loot table and put them in random slots of the chest
        //chest.getInventory().setItem();
    }
}
