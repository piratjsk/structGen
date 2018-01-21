package net.piratjsk.structgen.generator;

import net.piratjsk.structgen.StructGenPlugin;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class StructGenBlockPopulator extends BlockPopulator {

    private final StructGenPlugin plugin;

    public StructGenBlockPopulator(StructGenPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void populate(final World world, final Random random, final Chunk chunk) {
        this.plugin.getGenerator().generateStructures(chunk, random);
    }

}
