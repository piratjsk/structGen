package net.piratjsk.structgen;

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
        final WorldInitEvent initEvent = (WorldInitEvent) event;
        initEvent.getWorld().getPopulators().add(this.populator);
    }

}
