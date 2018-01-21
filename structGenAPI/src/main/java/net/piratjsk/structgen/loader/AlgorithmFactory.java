package net.piratjsk.structgen.loader;

import com.typesafe.config.Config;
import net.piratjsk.structgen.algorithms.Algorithm;
import net.piratjsk.structgen.algorithms.RandomAlgorithm;

public class AlgorithmFactory {

	public Algorithm getAlgorithm(final Config data) {
		switch (data.getString("type")) {
            case "random":
                final boolean onSurface = data.hasPath("onSurface") ? data.getBoolean("onSurface") : false;
                final int minHeight = data.hasPath("height.min") ? data.getInt("height.min") : 0;
                final int maxHeight = data.hasPath("height.max") ? data.getInt("height.max") : 127;
                return new RandomAlgorithm(minHeight, maxHeight, onSurface);
        }
        return null;
	}

}