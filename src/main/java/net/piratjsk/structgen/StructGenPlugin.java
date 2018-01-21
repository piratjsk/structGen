package net.piratjsk.structgen;

import net.piratjsk.structgen.commands.StructGenCommand;
import net.piratjsk.structgen.generator.WorldInitEventExecutor;
import net.piratjsk.structgen.loader.StructureLoader;
import org.bukkit.event.Event;
import org.bukkit.event.world.WorldListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class StructGenPlugin extends JavaPlugin {

    private final StructureGenerator generator;

    public StructGenPlugin() {
        this.generator = new StructureGenerator(new StructureLoader());
    }

    @Override
    public void onEnable() {
        this.registerBlockPopulator();
        this.loadStructures();
        this.setUpCommand();
    }

    private void registerBlockPopulator() {
        this.getServer().getPluginManager().registerEvent(Event.Type.WORLD_INIT, new WorldListener(), new WorldInitEventExecutor(this), Event.Priority.Normal, this);
    }

    public void loadStructures() {
        final File structuresDir = new File(this.getDataFolder(), "structures");
        if (!structuresDir.exists()) {
            structuresDir.mkdirs();
            return; // folder didn't exists, so there's no structures to load
        }
        if (!structuresDir.isDirectory()) return;

        for (final File file : Objects.requireNonNull(structuresDir.listFiles())) {
            if (!this.shouldLoad(file)) continue;
            try {
                this.generator.loadStructureFromFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean shouldLoad(final File structureFile) {
        final String name = structureFile.getName();
        if (!name.endsWith(".struct")) return false; // only load struct files
        if (name.startsWith("-")) return false; // skip disabled structures
        return true;
    }

    private void setUpCommand() {
        this.getCommand("structgen").setExecutor(new StructGenCommand(this));
    }

    public StructureGenerator getGenerator() {
        return this.generator;
    }

    @Override
    public void onDisable() {}

}