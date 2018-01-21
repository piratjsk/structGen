package net.piratjsk.structgen.bukkit;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.plugin.EventExecutor;

public class WorldInitEventExecutor implements EventExecutor {

    private final StructGenBlockPopulator populator;

    public WorldInitEventExecutor(final StructGenPlugin plugin) {
        this.populator = new StructGenBlockPopulator(plugin);
    }

    @Override
    public void execute(final Listener listener, final Event event) {
        WorldInitEvent initEvent = (WorldInitEvent) event;
        initEvent.getWorld().getPopulators().add(this.populator);
    }
}
