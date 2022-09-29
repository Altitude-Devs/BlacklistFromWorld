package com.alttd.blacklistfromworlds.events;

import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.Template;
import net.kyori.adventure.text.minimessage.template.TemplateResolver;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportEvent implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onTeleport(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        String name = event.getTo().getWorld().getName();
        if (player.hasPermission("blacklistfromworld." + name)) {
            player.sendMessage(MiniMessage.miniMessage()
                    .deserialize("<red>You are blacklisted from <world>, cancelling teleportation...</red>",
                            TemplateResolver.resolving(Template.template("world", name))));
            event.setCancelled(true);
        }
    }

}
