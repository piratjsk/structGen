package net.piratjsk.structgen.loaders;

import net.piratjsk.structgen.Structure;

import java.io.File;
import java.io.IOException;

public interface StructureLoader {
    Structure loadFromFile(File file) throws IOException;
    Structure loadFromString(String id, String string);
}
