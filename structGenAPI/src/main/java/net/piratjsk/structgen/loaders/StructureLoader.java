package net.piratjsk.structgen.loaders;

import net.piratjsk.structgen.Structure;
import net.piratjsk.structgen.loaders.structfiles.AlgorithmFactory;
import net.piratjsk.structgen.loaders.structfiles.ConditionFactory;
import net.piratjsk.structgen.loaders.structfiles.PartFactory;

import java.io.File;
import java.io.IOException;

public interface StructureLoader {
    Structure loadFromFile(File file) throws IOException;
    Structure loadFromString(String id, String string);

    AlgorithmFactory getAlgorithmFactory();
    ConditionFactory getConditionFactory();
    PartFactory getPartFactory();
}
