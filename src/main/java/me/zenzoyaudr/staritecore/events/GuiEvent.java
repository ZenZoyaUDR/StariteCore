package me.zenzoyaudr.staritecore.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class GuiEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    Player player;

    public GuiEvent(Player player) {
        this.player =player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlersList() {
        return HANDLERS;
    }

}
