package net.piratjsk.structgen.bukkit;

import com.typesafe.config.Config;
import net.piratjsk.structgen.conditions.Condition;
import net.piratjsk.structgen.loaders.structfiles.ConditionFactory;

public class BukkitConditionFactory extends ConditionFactory {

    @Override
    public Condition getCondition(final Config data) {
        // skip humidity condition as bukiit api for mc b1.7.3 returns it in octave noise format
        if (data.getString("type").equalsIgnoreCase("humidity")) {
            return null;
        }
        return super.getCondition(data);
    }
}
