package com.alttd.blacklistfromworlds;

import com.alttd.blacklistfromworlds.events.LoginEvent;
import com.alttd.blacklistfromworlds.events.TeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlacklistFromWorlds extends JavaPlugin {

    public static BlacklistFromWorlds instance;

    public static BlacklistFromWorlds getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new LoginEvent(), this);
        getServer().getPluginManager().registerEvents(new TeleportEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
