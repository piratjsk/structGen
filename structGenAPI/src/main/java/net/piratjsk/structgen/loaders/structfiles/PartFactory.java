package net.piratjsk.structgen.loaders.structfiles;

import com.typesafe.config.Config;
import net.piratjsk.structgen.parts.BlockPart;
import net.piratjsk.structgen.parts.Part;

public class PartFactory {

	public Part getPart(final Config data) {
        switch (data.getString("type")) {
            case "block":
                final int x = data.getInt("pos.x");
                final int y = data.getInt("pos.y");
                final int z = data.getInt("pos.z");
                final int id = data.getInt("id");
                final byte meta = data.hasPath("meta") ? (byte) data.getInt("meta") : 0;
                return new BlockPart(x, y, z, id, meta);
        }
        return null;
	}

}