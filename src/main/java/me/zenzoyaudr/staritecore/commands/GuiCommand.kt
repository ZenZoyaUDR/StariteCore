package me.zenzoyaudr.staritecore.commands

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class GuiCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player) {
            val gui = Bukkit.createInventory(null, 9, "Menu")

            // Item used in gui
            val suicide = ItemStack(Material.RED_DYE)
            val feed = ItemStack(Material.COOKED_BEEF)
            val suicide_meta = suicide.itemMeta
            suicide_meta.setDisplayName("Suicide")
            suicide.setItemMeta(suicide_meta)
            val feed_meta = feed.itemMeta
            feed_meta.setDisplayName("Feed")
            feed.setItemMeta(feed_meta)
            val menu_items = arrayOf(suicide, feed)
            gui.setContents(menu_items)
            sender.openInventory(gui)
        }
        return true
    }

}