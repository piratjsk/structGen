package net.piratjsk.structgen.algorithms;

import net.piratjsk.structgen.Chunk;
import net.piratjsk.structgen.Location;

import java.util.Random;

public class RandomAlgorithm implements Algorithm {

    private final int minHeight, maxHeight;

    public RandomAlgorithm() {
        this(0, 127);
    }

    public RandomAlgorithm(final int minHeight, final int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public Location findLocation(final Chunk chunk, final Random random) {
        int x = random.nextInt(15);
        int y = this.minHeight + random.nextInt(this.maxHeight - this.minHeight);
        int z = random.nextInt(15);
        return chunk.getLocation(x, y, z);
    }
}
