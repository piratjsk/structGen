package net.piratjsk.structgen.loaders.structfiles;

import com.typesafe.config.Config;
import net.piratjsk.structgen.algorithms.Algorithm;

public class AlgorithmFactory {

	public Algorithm getAlgorithm(final Config data) {
		switch (data.getString("type")) {
            case "random":

        }
        return null;
	}

}