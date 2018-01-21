package net.piratjsk.structgen.bukkit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

final class StructGenCommand implements CommandExecutor {

    private final StructGenPlugin plugin;
    private final String PREFIX = ChatColor.YELLOW + "[sg] " + ChatColor.WHITE;

    StructGenCommand(final StructGenPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final PluginDescriptionFile desc = this.plugin.getDescription();
        sender.sendMessage(PREFIX + desc.getName() + " v" + desc.getVersion());
        sender.sendMessage(PREFIX + " by: " + String.join(", ", desc.getAuthors()));
        return true;
    }
}
