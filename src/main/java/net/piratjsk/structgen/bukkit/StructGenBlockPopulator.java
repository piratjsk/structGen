package net.piratjsk.structgen.bukkit;

import net.piratjsk.structgen.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class StructGenBlockPopulator extends BlockPopulator {

    private final StructGenPlugin plugin;

    public StructGenBlockPopulator(StructGenPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void populate(final World world, final Random random, final org.bukkit.Chunk chunk) {
        final Chunk bukkitChunk = new BukkitChunk(chunk);
        this.plugin.getGenerator().generateStructures(bukkitChunk, random);
    }

}
