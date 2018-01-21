package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

import java.util.Random;

public class ChanceCondition implements Condition {

    private final int chance;
    private final Random random = new Random(); // TODO: use world gen rand instance

    public ChanceCondition(final int chance) {
        this.chance = chance;
    }

    @Override
    public boolean checkFor(final Location loc) {
        return (this.chance >= this.random.nextInt(100));
    }
}
