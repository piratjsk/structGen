package net.piratjsk.structgen.loader;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import net.piratjsk.structgen.Structure;
import net.piratjsk.structgen.StructureGenerator;
import net.piratjsk.structgen.algorithms.Algorithm;
import net.piratjsk.structgen.conditions.Condition;
import net.piratjsk.structgen.parts.Part;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StructureLoader {

    private AlgorithmFactory algFactory;
    private ConditionFactory condFactory;
    private PartFactory partFactory;

    public StructureLoader() { }

    public StructureLoader(final StructureGenerator structureGenerator) {
        this(new AlgorithmFactory(), new ConditionFactory(), new PartFactory(structureGenerator));
    }

    public StructureLoader(final AlgorithmFactory algorithms, final ConditionFactory conditions, final PartFactory parts) {
        this.algFactory = algorithms;
        this.condFactory = conditions;
        this.partFactory = parts;
    }

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

    public Structure loadFromString(final String id, final String string) {
        final Config data = ConfigFactory.parseString(string);
        return this.loadFromConfig(id, data);

    }

    public AlgorithmFactory getAlgorithmFactory() {
        return this.algFactory;
    }

    public ConditionFactory getConditionFactory() {
        return this.condFactory;
    }

    public PartFactory getPartFactory() {
        return this.partFactory;
    }

    public void setAlgorithmFactory(final AlgorithmFactory algorithmFactory) {
        this.algFactory = algorithmFactory;
    }

    public void setConditionFactory(final ConditionFactory conditionFactory) {
        this.condFactory = conditionFactory;
    }

    public void setPartFactory(final PartFactory partFactory) {
        this.partFactory = partFactory;
    }

    public Structure loadFromConfig(final String id, final Config data) {
        // tries per chunk
        int tries = data.getInt("triesPerChunk");

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
