package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

import java.util.Random;

public class ChanceCondition implements Condition {

    private final int chance;

    public ChanceCondition(final int chance) {
        this.chance = chance;
    }

    @Override
    public boolean checkFor(final Location loc, final Random random) {
        return (this.chance >= random.nextInt(100));
    }
}
