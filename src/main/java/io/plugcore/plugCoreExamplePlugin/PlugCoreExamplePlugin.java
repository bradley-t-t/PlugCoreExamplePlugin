package io.plugcore.plugCoreExamplePlugin;

import io.plugcore.plugCore.api.PlugCoreAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlugCoreExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!PlugCoreAPI.isServerLinked()) {
            getLogger().warning("Server not linked to PlugCore!");
            disablePlugin();
            return;
        }

        checkAuthorization();
    }

    private void checkAuthorization() {
        PlugCoreAPI.isPluginAuthorized("PlugCoreExamplePlugin").thenAccept(authorized -> {
            if (!authorized) {
                getLogger().severe("Not authorized! This plugin must be purchased from plugcore.io");
                disablePlugin();
            } else {
                getLogger().info("Authorization verified! PlugCoreExamplePlugin is now active.");
                loadPlugin();
            }
        });
    }

    private void loadPlugin() {
        getLogger().info("PlugCoreExamplePlugin enabled successfully!");
    }

    private void disablePlugin() {
        getServer().getScheduler().runTask(this, () -> {
            getServer().getPluginManager().disablePlugin(this);
        });
    }

    @Override
    public void onDisable() {
        getLogger().info("PlugCoreExamplePlugin disabled.");
    }
}
