package net.piratjsk.structgen.bukkit;

import com.typesafe.config.Config;
//import net.piratjsk.structgen.bukkit.parts.ChestPart;
import net.piratjsk.structgen.bukkit.parts.SpawnerPart;
import net.piratjsk.structgen.loaders.structfiles.PartFactory;
import net.piratjsk.structgen.parts.Part;

public class BukkitPartFactory extends PartFactory {

    @Override
    public Part getPart(final Config data) {
        if (data.getString("type").equalsIgnoreCase("block")) {
            switch (data.getInt("id")) {
                case 52:
                    final int spawnerX = data.getInt("pos.x");
                    final int spawnerY = data.getInt("pos.y");
                    final int spawnerZ = data.getInt("pos.z");
                    final String mobType = data.getString("mobType");
                    return new SpawnerPart(spawnerX,spawnerY,spawnerZ,mobType);
//                case 54:
//                    final int chestX = data.getInt("pos.x");
//                    final int chestY = data.getInt("pos.y");
//                    final int chestZ = data.getInt("pos.z");
//                    final String lootTable = data.getString("lootTable");
//                    return new ChestPart(chestX,chestY,chestZ,lootTable);
            }
        }
        return super.getPart(data);
    }
}
