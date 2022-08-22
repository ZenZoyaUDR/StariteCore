package me.zenzoyaudr.staritecore

import me.zenzoyaudr.staritecore.commands.*
import me.zenzoyaudr.staritecore.events.*
import me.zenzoyaudr.staritecore.gui.*
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    override fun onEnable() {
        // Register Stuff
        registerEvents();
        registerCommands();

        // Info on Enabled
        logger.info("Plugin Enabled!")
    }

    private fun registerEvents() {
        server.pluginManager.registerEvents(TestGui(), this);
    }

    private fun registerCommands() {
        getCommand("test")?.setExecutor(TestCommand());
        getCommand("menu")?.setExecutor(GlowCommand());
    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("Plugin Disabled!")
    }

}
