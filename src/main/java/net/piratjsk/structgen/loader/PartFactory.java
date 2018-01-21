package net.piratjsk.structgen.loader;

import com.typesafe.config.Config;
import net.piratjsk.structgen.parts.BlockPart;
import net.piratjsk.structgen.parts.Part;
import net.piratjsk.structgen.parts.RandomPartPart;
import net.piratjsk.structgen.parts.SpawnerPart;

import java.util.HashSet;
import java.util.Set;

public class PartFactory {

	public Part getPart(final Config data) {
        switch (data.getString("type")) {
            case "block":
                if (data.getInt("id") == 52) {
                    final int spawnerX = data.getInt("pos.x");
                    final int spawnerY = data.getInt("pos.y");
                    final int spawnerZ = data.getInt("pos.z");
                    final String mobType = data.getString("mobType");
                    return new SpawnerPart(spawnerX,spawnerY,spawnerZ,mobType);
                } 
                if (data.getInt("id") == 54){
                    // TODO: implement chest part
                }
                final int blockX = data.getInt("pos.x");
                final int blockY = data.getInt("pos.y");
                final int blockZ = data.getInt("pos.z");
                final int blockId = data.getInt("id");
                final byte blockMeta = data.hasPath("meta") ? (byte) data.getInt("meta") : 0;
                return new BlockPart(blockX, blockY, blockZ, blockId, blockMeta);
            case "random":
                final double randomX = data.getInt("pos.x");
                final double randomZ = data.getInt("pos.y");
                final double randomY = data.getInt("pos.z");
                final Set<Part> randomParts = new HashSet<>();
                for (final Config partData : data.getConfigList("parts")) {
                    final Part part = this.getPart(partData);
                    part.setRelativePos(randomX, randomY, randomZ);
                    final int weight = partData.hasPath("weight") ? partData.getInt("weight") : 1;
                    for (int i=0; i<weight; ++i)
                        randomParts.add(part);
                }
                return new RandomPartPart(randomX, randomY, randomZ, randomParts);
        }
        return null;
	}

}