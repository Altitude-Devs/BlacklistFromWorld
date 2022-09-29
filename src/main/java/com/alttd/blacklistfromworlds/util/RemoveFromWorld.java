package com.alttd.blacklistfromworlds.util;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class RemoveFromWorld {

    public static void teleportPlayer(Player player) {
        World defaultWorld = Bukkit.getWorld("world");
        if (defaultWorld != null && !player.hasPermission("blacklistfromworld.world")) {
            player.teleport(defaultWorld.getSpawnLocation());
            player.sendMessage(MiniMessage.miniMessage()
                    .deserialize("<green>You were teleported out of a world you're blacklisted in!</green>"));
            Logger.info("Teleported % to %", player.getName(), defaultWorld.getSpawnLocation().toString());
            return;
        }
        for (World world : Bukkit.getWorlds()) {
            if (player.hasPermission("blacklistfromworld." + world.getName()))
                continue;
            player.teleport(world.getSpawnLocation());
            player.sendMessage(MiniMessage.miniMessage()
                    .deserialize("<green>You were teleported out of a world you're blacklisted in!</green>"));
            Logger.info("Teleported % to %", player.getName(), world.getSpawnLocation().toString());
            return;
        }
        player.kick(MiniMessage.miniMessage()
                .deserialize("<red>You are blacklisted from all worlds on this server.</red>"));
    }

}
