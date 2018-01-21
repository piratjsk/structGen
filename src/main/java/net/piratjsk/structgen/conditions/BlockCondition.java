package net.piratjsk.structgen.conditions;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.Random;

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
    public boolean checkFor(final Location loc, final Random random) {
        final Block block = loc.add(this.x, this.y, this.z).getBlock();
        return block.getTypeId() == this.id && block.getData() == this.meta;
    }

}
