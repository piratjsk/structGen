package net.piratjsk.wesga;

import com.sk89q.worldedit.*;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
