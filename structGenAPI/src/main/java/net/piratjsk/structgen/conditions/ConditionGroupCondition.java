package net.piratjsk.structgen.conditions;

import net.piratjsk.structgen.Location;

import java.util.ArrayList;
import java.util.Collection;

public class ConditionGroupCondition implements Condition {

    private Collection<Condition> conditions = new ArrayList<>();
    private boolean or;

    public ConditionGroupCondition(final Collection<Condition> conditions) {
        this(conditions, false);
    }

    public ConditionGroupCondition(final Collection<Condition> conditions, final boolean or) {
        this.conditions = conditions;
        this.or = or;
    }

    @Override
    public boolean checkFor(final Location loc) {
        for (final Condition cond : this.conditions) {
            if (this.or) {
                if (cond.checkFor(loc)) return true;
            } else {
                if (!cond.checkFor(loc)) return false;
            }
        }
        return true;
    }
}
