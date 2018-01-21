package net.piratjsk.structgen.algorithms;

import net.piratjsk.structgen.Chunk;
import net.piratjsk.structgen.Location;
import net.piratjsk.structgen.loader.AlgorithmFactory;

import java.util.Random;

public class RandomAlgorithm implements Algorithm {

    private final int minHeight, maxHeight;
    private final boolean onSurface;

    public RandomAlgorithm() {
        this(0, 127, false);
    }

    public RandomAlgorithm(final boolean onSurface) {
        this(0, 127, onSurface);
    }

    public RandomAlgorithm(final int minHeight, final int maxHeight, final boolean onSurface) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.onSurface = onSurface;
    }

    @Override
    public Location findLocation(final Chunk chunk, final Random random) {
        int x = random.nextInt(15);
        int z = random.nextInt(15);
        int y = 0;
        if (this.onSurface) {
            y = chunk.getLocation(x,y,z).getSurfaceLevel();
        } else {
            y = this.minHeight + random.nextInt(this.maxHeight - this.minHeight);
        }
        return chunk.getLocation(x, y, z);
    }
}
