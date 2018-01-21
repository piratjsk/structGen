package net.piratjsk.wesga;

import org.bukkit.plugin.java.JavaPlugin;

public class StructGenPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("structgen").setExecutor(new StructGenCommand(this));
    }

    @Override
    public void onDisable() {}

}