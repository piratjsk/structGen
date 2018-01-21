package net.piratjsk.structgen.parts;

import org.bukkit.Location;

import java.util.Random;

public class BlockPart implements Part {

    private int x, y, z;
    private final int id;
    private final byte meta;

    public BlockPart(final int x, final int y, final int z, final int id) {
        this(x, y, z, id, (byte)0);
    }

    public BlockPart(final int x, final int y, final int z, final int id, final byte meta) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.id = id;
        this.meta = meta;
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
        pointOfOrigin.add(this.x, this.y, this.z).getBlock().setTypeIdAndData(this.id, this.meta, true);
    }

}
