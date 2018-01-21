package net.piratjsk.structgen.algorithms;

import net.piratjsk.structgen.Chunk;
import net.piratjsk.structgen.Location;

import java.util.Random;

public class RandomAlgorithm implements Algorithm {

    private final int minHeight, maxHeight;
    private final Random random = new Random(); // TODO: use world gen rand instance

    public RandomAlgorithm() {
        this(0, 127);
    }

    public RandomAlgorithm(final int minHeight, final int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public Location findLocation(final Chunk chunk) {
        int x = this.random.nextInt(15);
        int y = this.minHeight + this.random.nextInt(this.maxHeight - this.minHeight);
        int z = this.random.nextInt(15);
        return chunk.getLocation(x, y, z);
    }
}
