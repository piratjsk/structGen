package net.piratjsk.structgen.parts;

import net.piratjsk.structgen.Location;

public class BlockPart implements Part {

    private final int x, y, z;
    private final int id, meta;

    public BlockPart(final int x, final int y, final int z, final int id) {
        this(x, y, z, id, 0);
    }

    public BlockPart(final int x, final int y, final int z, final int id, final int meta) {
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
    public void putAt(final Location pointOfOrigin) {
        pointOfOrigin.getRelative(this.x, this.y, this.z).setBlock(this.id, this.meta);
    }
}
