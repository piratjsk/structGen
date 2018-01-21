package net.piratjsk.structgen.loaders.structfiles;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import net.piratjsk.structgen.Structure;
import net.piratjsk.structgen.algorithms.Algorithm;
import net.piratjsk.structgen.conditions.Condition;
import net.piratjsk.structgen.loaders.StructureLoader;
import net.piratjsk.structgen.parts.Part;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StructFileStructureLoader implements StructureLoader {

    private final AlgorithmFactory algFactory;
    private final ConditionFactory condFactory;
    private final PartFactory partFactory;

    public StructFileStructureLoader() {
        this(new AlgorithmFactory(), new ConditionFactory(), new PartFactory());
    }

    public StructFileStructureLoader(final AlgorithmFactory algorithms, final ConditionFactory conditions, final PartFactory parts) {
        this.algFactory = algorithms;
        this.condFactory = conditions;
        this.partFactory = parts;
    }

    @Override
    public Structure loadFromFile(final File file) throws IOException {
        if (!file.exists()) throw new FileNotFoundException();
        if (!file.getName().endsWith(".struct")) return null;

        final String id = file.getName().replace(".struct","");

        final String fileContent = this.readFile(file.getPath(),Charset.defaultCharset());

        return this.loadFromString(id, fileContent);
    }

    private String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    @Override
    public Structure loadFromString(final String id, final String string) {
        final Config data = ConfigFactory.parseString(string);
        return this.loadFromConfig(id, data);

    }

    public Structure loadFromConfig(final String id, final Config data) {
        // tries per chunk
        int tries = data.getInt("roolsPerChunk");

        // algorithm
        final Config algorithmData = data.getConfig("location");
        final Algorithm algorithm = this.algFactory.getAlgorithm(algorithmData);
        if (algorithm == null) return null; // TODO: notify about failure, maybe throw an exception

        // conditions
        final ArrayList<Condition> conditions = new ArrayList<>();
        for (Config condData : data.getConfigList("conditions")) {
            Condition cond = this.condFactory.getCondition(condData);
            if (cond != null) conditions.add(cond);
        }

        // parts
        final ArrayList<Part> parts = new ArrayList<>();
        for (Config partData : data.getConfigList("structure")) {
            Part part = this.partFactory.getPart(partData);
            if (part != null) parts.add(part);
        }

        return new Structure(id, tries, algorithm, conditions, parts);
    }
}
