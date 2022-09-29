package com.alttd.blacklistfromworlds.events;

import com.alttd.blacklistfromworlds.util.RemoveFromWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onLoginEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("blacklistfromworld." + event.getPlayer().getWorld().getName()))
            RemoveFromWorld.teleportPlayer(player);
    }

}
