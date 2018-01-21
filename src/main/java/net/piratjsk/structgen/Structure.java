package net.piratjsk.structgen;

import net.piratjsk.structgen.algorithms.Algorithm;
import net.piratjsk.structgen.conditions.Condition;
import net.piratjsk.structgen.parts.Part;

import java.util.Collection;
import java.util.Random;

public class Structure {

	private final int tries;
	private final Algorithm algorithm;
	private final Collection<Condition> conditions;
	private final Collection<Part> structureParts;
	private final String id;

	public Structure(final String id, final int tries, final Algorithm algorithm, final Collection<Condition> conditions, final Collection<Part> structureParts) {
		this.id = id;
		this.tries = tries;
		this.algorithm = algorithm;
		this.conditions = conditions;
		this.structureParts = structureParts;
	}

	public int getTries() {
		return this.tries;
	}

    public Algorithm getAlgorithm() {
        return this.algorithm;
    }

    public boolean canGenerateAt(final Location pointOfOrigin, final Random random) {
		for (final Condition cond : this.conditions) {
			if (!cond.checkFor(pointOfOrigin, random)) return false;
		}
		return true;
	}

	public void generate(final Location loc, final Random random) {
		for (final Part part : this.structureParts) {
			part.putAt(loc, random);
		}
	}

}