package net.piratjsk.structgen.loaders.structfiles;

import com.typesafe.config.Config;
import net.piratjsk.structgen.conditions.*;

import java.util.ArrayList;
import java.util.Collection;

public class ConditionFactory {

	public Condition getCondition(final Config data) {
	    switch (data.getString("type")) {
            case "block":
                final int x = data.getInt("pos.x");
                final int y = data.getInt("pos.y");
                final int z = data.getInt("pos.z");
                final int id = data.getInt("id");
                final int meta = data.hasPath("meta") ? data.getInt("meta") : 0;
                return new BlockCondition(x, y, z, id, meta);
            case "conditionGroup":
                final Collection<Condition> conditions = new ArrayList<>();
                final boolean or = data.getString("relation").equalsIgnoreCase("or");
                for (final Config condData : data.getConfigList("conditions")) {
                    final Condition cond = this.getCondition(condData);
                    conditions.add(cond);
                }
                return new ConditionGroupCondition(conditions, or);
            case "chance":
                final int chance = data.getInt("chance");
                return new ChanceCondition(chance);
            case "biome":
                final String biome = data.getString("biome");
                return new BiomeCondition(biome);
            case "height":
                final int minHeight = data.getInt("min");
                final int maxHeight = data.getInt("max");
                return new HeightCondition(minHeight, maxHeight);
            case "dimension":
                final String dimension = data.getString("dimension");
                return new DimensionCondition(dimension);
            case "temperature":
                final double minTemperature = data.getDouble("min");
                final double maxTemperature = data.getDouble("max");
                return new TemperatureCondition(minTemperature, maxTemperature);
            case "humidity":
                final double minHumidity = data.getDouble("min");
                final double maxHumidity = data.getDouble("max");
                return new HumidityCondition(minHumidity, maxHumidity);
            case "underGround":
                final boolean value = data.getBoolean("value");
                return new UnderGroundCondition(value);
            case "world":
                final String worldName = data.getString("world");
                return new WorldCondition(worldName);
        }
        return null;
	}

}