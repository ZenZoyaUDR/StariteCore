package me.zenzoyaudr.staritecore.commands;

import me.zenzoyaudr.staritecore.events.GuiEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GlowCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Bukkit.getServer().getPluginManager().callEvent(new GuiEvent((Player) sender));
            return true;
        } else {
            Bukkit.getLogger().info("You have to be a player to run this command.");
        }

        return false;
    }
}
