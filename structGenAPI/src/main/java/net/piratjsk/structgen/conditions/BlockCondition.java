package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

public class BlockCondition implements Condition {

    private int x, y, z, id;
    private byte meta;

    public BlockCondition(final int x, final int y, final int z, final int id) {
        this(x, y, z, id, (byte) 0);
    }


    public BlockCondition(final int x, final int y, final int z, final int id, final byte meta) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.id = id;
        this.meta = meta;
    }

    @Override
    public boolean checkFor(final Location loc) {
        Location blockLoc = loc.getRelative(this.x, this.y, this.z);
        return blockLoc.getBlockId() == this.id && blockLoc.getBlockMeta() == this.meta;
    }
}
