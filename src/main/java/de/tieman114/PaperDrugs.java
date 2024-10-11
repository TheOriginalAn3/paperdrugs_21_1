package de.tieman114;

import org.bukkit.plugin.java.JavaPlugin;

import de.tieman114.commands.AddTradeCommand;
import de.tieman114.commands.ChangeVillagerYawCommand;
import de.tieman114.commands.GetDrugsCommand;
import de.tieman114.commands.GetWTraderSpawnEggCommand;
import de.tieman114.commands.ListDecorativeAnvilsCommand;
import de.tieman114.commands.RemoveTradeCommand;
import de.tieman114.commands.ShowDebugStatementsCommand;
import de.tieman114.commands.SpawnCustomVillagerCommand;
import de.tieman114.fileManagers.AnvilLocationManager;
import de.tieman114.items.CustomRecipes;
import de.tieman114.listeners.BlockBreakListener;
import de.tieman114.listeners.BlockInteractListener;
import de.tieman114.listeners.BlockPlaceListener;
import de.tieman114.listeners.ItemClickListener;
import de.tieman114.listeners.WanderingTraderListener;

public class PaperDrugs extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getServer().getLogger().info("PaperDrugs enabled!");

        AnvilLocationManager.loadLocations();

        getServer().getPluginManager().registerEvents(new ItemClickListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new BlockInteractListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        // getServer().getPluginManager().registerEvents(new InventoryListener(), this);

        registerCommands();

        CustomRecipes.register(this);
        getServer().getPluginManager().registerEvents(new WanderingTraderListener(), this);
    }


    @Override
    public void onDisable() {
        AnvilLocationManager.saveLocations();
    }


    void registerCommands() {
        getCommand("paperdrugs.getwtegg").setExecutor(new GetWTraderSpawnEggCommand());
        getCommand("paperdrugs.getdrugs").setExecutor(new GetDrugsCommand());
        getCommand("paperdrugs.showdebugstatements").setExecutor(new ShowDebugStatementsCommand());
        getCommand("paperdrugs.listdecorativeanvils").setExecutor(new ListDecorativeAnvilsCommand());
        getCommand("paperdrugs.spawncustomvillager").setExecutor(new SpawnCustomVillagerCommand());
        getCommand("paperdrugs.changevillageryaw").setExecutor(new ChangeVillagerYawCommand());
        getCommand("paperdrugs.addtrade").setExecutor(new AddTradeCommand());
        getCommand("paperdrugs.removetrade").setExecutor(new RemoveTradeCommand());
    }
}