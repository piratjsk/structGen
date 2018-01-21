package net.piratjsk.structgen.bukkit;

import net.piratjsk.structgen.StructureGenerator;
import net.piratjsk.structgen.loaders.structfiles.StructFileStructureLoader;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class StructGenPlugin extends JavaPlugin {

    private StructureGenerator generator = new StructureGenerator(new StructFileStructureLoader());

    @Override
    public void onEnable() {
        this.getCommand("structgen").setExecutor(new StructGenCommand(this));
        this.loadStructures();

        final BlockPopulator populator = new StructGenBlockPopulator(this);
        for (final World world : this.getServer().getWorlds()) {
            world.getPopulators().add(populator);
        }
    }

    public void loadStructures() {
        final File dataFolder = this.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
            return;
        }

        for (final File file : Objects.requireNonNull(this.getDataFolder().listFiles())) {
            try {
                this.generator.loadStructureFromFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public StructureGenerator getGenerator() {
        return this.generator;
    }

    @Override
    public void onDisable() {}

}