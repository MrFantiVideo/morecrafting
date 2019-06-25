package net.mrfantivideo.morecrafting;

import net.mrfantivideo.morecrafting.Command.Commands.BookCommand;
import net.mrfantivideo.morecrafting.Command.Commands.HelpCommand;
import net.mrfantivideo.morecrafting.Command.Commands.ReloadCommand;
import net.mrfantivideo.morecrafting.Command.CommandsManager;
import net.mrfantivideo.morecrafting.Configuration.Configs.ConfigMessages;
import net.mrfantivideo.morecrafting.Configuration.Configs.ConfigPermissions;
import net.mrfantivideo.morecrafting.Configuration.Configs.ConfigSettings;
import net.mrfantivideo.morecrafting.Listeners.PlayerInteractListener;
import net.mrfantivideo.morecrafting.Listeners.PlayerInventoryListener;
import net.mrfantivideo.morecrafting.Recipes.CustomRecipe;
import net.mrfantivideo.morecrafting.Recipes.RecipesManager;
import net.mrfantivideo.morecrafting.Utils.EConfig;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

import static net.mrfantivideo.morecrafting.Utils.ConfigUtils.Get;

public class Main extends JavaPlugin
{
    private static Main s_instance;
    private ConfigSettings m_configSettings;
    private ConfigPermissions m_configPermissions;
    private ConfigMessages m_configMessages;

    public Main()
    {
        s_instance = this;
    }

    public static Main GetInstance()
    {
        return s_instance;
    }

    public ConfigSettings GetConfigSettings()
    {
        return m_configSettings;
    }

    public ConfigPermissions GetConfigPermissions()
    {
        return m_configPermissions;
    }

    public ConfigMessages GetConfigMessages()
    {
        return m_configMessages;
    }

    /*
        Called when enabling
     */
    public void onEnable()
    {
        LoadSettings();

        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInventoryListener(), this);

        new CommandsManager();
        CommandsManager.GetInstance().RegisterCommand(new ReloadCommand());
        CommandsManager.GetInstance().RegisterCommand(new HelpCommand());
        CommandsManager.GetInstance().RegisterCommand(new BookCommand());

        new RecipesManager();

        BroadcastEnabledMessage();
    }

    /*
    Broadcast the enabling message
    */
    private void BroadcastEnabledMessage()
    {
    	System.out.println(" ");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "             ÉÍÍÍÍÍÍÍÍÍÍÍÍÍÍ»");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "ÉÍÍÍÍÍÍÍÍÍÍÍÍ¹" + ChatColor.GOLD + " MoreCrafting " + ChatColor.DARK_GRAY + "ÌÍÍÍÍÍÍÍÍÍÍÍÍ»");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "º            ÈÍÍÍÍÍÍÍÍÍÍÍÍÍÍ¼            º");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "º " + ChatColor.GRAY + "Plugin ¯ " + ChatColor.GREEN + "ON " + ChatColor.GRAY + "            Minecraft 1.14" + ChatColor.DARK_GRAY + " º");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "º " + ChatColor.GRAY + "Version ¯ " + ChatColor.YELLOW + "3.0" + ChatColor.DARK_GRAY + "              (Dev Build) º");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "º                                        º");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "ÌÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍËÍÍÍÍÍÍÍÍÍÍÍÍÍ¹");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "º Created by " + ChatColor.GRAY + "MrFantiVideo" + ChatColor.DARK_GRAY + "  º 2018 - 2019 º");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "ÈÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÊÍÍÍÍÍÍÍÍÍÍÍÍÍ¼");
    	System.out.println(" ");
    	getServer().getConsoleSender().sendMessage(ChatColor.RED + "ÉÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ»");
    	getServer().getConsoleSender().sendMessage(ChatColor.RED + "º This is a trial version with Spigot 1.14 º");
    	getServer().getConsoleSender().sendMessage(ChatColor.RED + "ÈÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ¼");
    	System.out.println(" ");
    }

    /*
    	Broadcast the disabling message
     */
    public void onDisable()
    {
    	System.out.println(" ");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "             ÉÍÍÍÍÍÍÍÍÍÍÍÍÍÍ»");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "ÉÍÍÍÍÍÍÍÍÍÍÍÍ¹" + ChatColor.YELLOW + " MoreCrafting " + ChatColor.DARK_GRAY + "ÌÍÍÍÍÍÍÍÍÍÍÍÍ»");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "º            ÈÍÍÍÍÍÍÍÍÍÍÍÍÍÍ¼            º");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "º " + ChatColor.GRAY + "Plugin ¯ " + ChatColor.RED + "OFF" + ChatColor.GRAY + "            Minecraft 1.14" + ChatColor.DARK_GRAY + " º");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "º " + ChatColor.GRAY + "Version ¯ " + ChatColor.YELLOW + "3.0" + ChatColor.DARK_GRAY + "              (Dev Build) º");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "º                                        º");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "ÌÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍËÍÍÍÍÍÍÍÍÍÍÍÍÍ¹");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "º Created by " + ChatColor.GRAY + "MrFantiVideo" + ChatColor.DARK_GRAY + "  º 2018 - 2019 º");
    	getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "ÈÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÊÍÍÍÍÍÍÍÍÍÍÍÍÍ¼");
    	System.out.println(" ");
    	getServer().getConsoleSender().sendMessage(ChatColor.RED + "ÉÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ»");
    	getServer().getConsoleSender().sendMessage(ChatColor.RED + "º This is a trial version with Spigot 1.14 º");
    	getServer().getConsoleSender().sendMessage(ChatColor.RED + "ÈÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ¼");
    	System.out.println(" ");
    }

    /*
        Load/Reload settings
     */
    public void LoadSettings()
    {
        m_configSettings = new ConfigSettings();
        m_configMessages = new ConfigMessages();
        m_configPermissions = new ConfigPermissions();
    }
}

/// Todo :
///         Enregistrer les settings recurrent pour ÃÂ©viter d'aller rechercher dans la config a chaques fois, par exemple pour le prefix des messages, ou pour chaques permissions

