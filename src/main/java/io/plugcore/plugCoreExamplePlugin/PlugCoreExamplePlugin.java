package io.plugcore.plugCoreExamplePlugin;

import io.plugcore.plugCore.api.PlugCoreAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlugCoreExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!PlugCoreAPI.requireAuthorization(this)) {
            getServer().getPluginManager().disablePlugin(this);
            getLogger().info("PlugCoreExamplePlugin disabled on post-load.");
            return;
        }

        getLogger().info("PlugCoreExamplePlugin enabled and authorized!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PlugCoreExamplePlugin disabled.");
    }
}
