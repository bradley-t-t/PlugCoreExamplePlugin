package io.plugcore.plugCoreExamplePlugin;

import io.plugcore.plugCore.api.PlugCoreAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlugCoreExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            if (!PlugCoreAPI.requireAuthorization(this)) {
                getServer().getPluginManager().disablePlugin(this);
                return;
            }

            getLogger().info("PlugCoreExamplePlugin enabled and authorized!");
        } catch (NoClassDefFoundError e) {
            getLogger().severe("PlugCore not found! Download from https://plugcore.io");
            getServer().getPluginManager().disablePlugin(this);
        } catch (Exception e) {
            getLogger().severe("Authorization error: " + e.getMessage());
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("PlugCoreExamplePlugin disabled.");
    }
}
