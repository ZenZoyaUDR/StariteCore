package me.zenzoyaudr.staritecore.commands

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.util.Vector

class TestCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false
        if(!sender.isOp) { sender.sendMessage(Component.text("You do not have permissions to use this command").color(TextColor.color(255, 0, 0))); return false }
        if(args.isEmpty()) return false
        if(args[0].isEmpty()) return false

        val targetPlayer = Bukkit.getPlayer(args[0])

        if(targetPlayer == null) {
            sender.sendMessage(Component.text("That player does not exist").color(TextColor.color(255, 0, 0)))
            return false
        }

        targetPlayer.velocity = targetPlayer.velocity.add(Vector(0, 10, 0))
        targetPlayer.sendMessage(Component.text("Yeet!").color(TextColor.color(0, 255, 75)))

        return false
    }

}
