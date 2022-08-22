package me.zenzoyaudr.staritecore.gui;

import me.zenzoyaudr.staritecore.events.GuiEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TestGui implements Listener {

    private Inventory gui;

    private void openNewGui(Player p) {
        gui = Bukkit.createInventory(null, 45, ChatColor.AQUA + "Test Menu");

        // Items
        ItemStack item_enable_glow = new ItemStack(Material.LIME_DYE, 1);
        ItemStack item_disable_glow = new ItemStack(Material.RED_DYE, 1);
        ItemMeta meta_enable = item_enable_glow.getItemMeta();
        ItemMeta meta_disable = item_disable_glow.getItemMeta();

        meta_disable.setDisplayName(ChatColor.RED + "Disable Glow");
        meta_enable.setDisplayName(ChatColor.GREEN + "Enable Glow");
        item_enable_glow.setItemMeta(meta_enable);
        item_disable_glow.setItemMeta(meta_disable);

        gui.setItem(21, item_enable_glow);
        gui.setItem(23, item_disable_glow);

        p.openInventory(gui);
    }

    @EventHandler
    public void guiClickEvent(InventoryClickEvent e) {
        if(!e.getInventory().equals(gui)) return;
        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();

        if(e.getSlot() == 21) {
            p.setGlowing(true);
            p.sendMessage(Component.text("You clicked the button!").color(TextColor.color(0, 255, 75)));
        }
        if(e.getSlot() == 23) {
            p.setGlowing(false);
            p.sendMessage(Component.text("You clicked the button!").color(TextColor.color(0, 255, 75)));
        }
    }

    @EventHandler
    public void  openGuiEvent(GuiEvent e) {
        openNewGui(e.getPlayer());
    }

}
