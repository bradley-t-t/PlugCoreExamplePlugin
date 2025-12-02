package io.plugcore.plugCoreExamplePlugin;

import io.plugcore.plugCore.api.PlugCoreAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlugCoreExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            PlugCoreAPI plugCore = PlugCoreAPI.getInstance();
            if (plugCore == null || !plugCore.isServerLinked()) {
                getServer().getPluginManager().disablePlugin(this);
            }
        } catch (Exception e) {
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
    }
}
