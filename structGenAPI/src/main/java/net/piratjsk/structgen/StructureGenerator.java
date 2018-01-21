package net.piratjsk.structgen;

import net.piratjsk.structgen.loaders.StructureLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class StructureGenerator {

	private final Map<String, Structure> structures = new HashMap<>();
    private final StructureLoader defaultLoader;

	public StructureGenerator(final StructureLoader defaultLoader) {
        this.defaultLoader = defaultLoader;
    }

	public void registerStructure(String name, Structure structure) {
		this.structures.put(name, structure);
	}

	public Structure getStructure(String name) {
		return this.structures.get(name);
	}

    public boolean hasStructure(String name) {
        return this.structures.containsKey(name);
    }

    public StructureLoader getStructureLoader() {
        return this.defaultLoader;
    }

    public void generateStructure(String name, Chunk chunk) {
		Structure struct = this.structures.get(name);
		IntStream.range(0, struct.getTries()).forEachOrdered(n -> {
			Location loc = struct.getAlgorithm().findLocation(chunk);
			if (struct.canGenerateAt(loc)) {
				struct.generate(loc);
            }
		});
	}

	public void loadStructureFromFile(final File file) throws IOException {
        this.loadStructureFromFile(this.defaultLoader, file);
    }

    public void loadStructureFromFile(final StructureLoader loader, final File file) throws IOException {
        final Structure struct = loader.loadFromFile(file);
        final String id = file.getName().replace(".struct","");
        this.structures.put(id, struct);
    }

}