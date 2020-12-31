package xyz.kerubu.lmresources.lmresources;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.kerubu.lmresources.lmresources.Events.EventBlockBreak;

public final class LMResources extends JavaPlugin {

    PluginDescriptionFile PDFile = getDescription();


    @Override
    public void onEnable() {
        // Plugin startup logic
        //Events
        registerEvents();

        Bukkit.getConsoleSender().sendMessage("<======================[PLUGIN]=======================>");
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.DARK_AQUA + "The " + PDFile.getName() + ChatColor.DARK_AQUA +
                        " plugin was created by MrNizzy");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"Version: "+PDFile.getVersion());
        Bukkit.getConsoleSender().sendMessage("<======================[ENABLED]======================>");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.DARK_AQUA + "The plugin " + PDFile.getName() +
                        ChatColor.DARK_AQUA + " has been disabled.");
    }

    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        //pm.registerEvents(new movement(), this);
        pm.registerEvents(new EventBlockBreak(), this);
    }
}
