package me.snowzen.snowzenresources;

import org.bukkit.Bukkit;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import me.snowzen.snowzenresources.Configs.Config;
import me.snowzen.snowzenresources.Events.Events;
import me.snowzen.snowzenresources.commands.GetIP;
import me.snowzen.snowzenresources.commands.HelloCommand;
import me.snowzen.snowzenresources.commands.SnowGive;
import me.snowzen.snowzenresources.customWorldGen.TestWorldGen;
//import me.snowzen.snowzenresources.commands.snowgive;
import me.snowzen.snowzenresources.customWorldGen.Biomes.SimpleBiomeProvider;
import me.snowzen.snowzenresources.entities.CustomMob;
import me.snowzen.snowzenresources.gui.bedwars.ItemShopGUI;
import me.snowzen.snowzenresources.items.CustomCrafts;
import me.snowzen.snowzenresources.skills.Skills;

public class Main extends JavaPlugin{
	
	public static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new Skills(), this);
		Bukkit.getPluginManager().registerEvents(new Events(), this);
		Bukkit.getPluginManager().registerEvents(new ItemShopGUI(), this);
		new HelloCommand(this);
		new SnowGive(this);
		new CustomMob(this);
		new GetIP(this);
		Config.startup();
		getServer().addRecipe(CustomCrafts.hardDiamondSword());
	}
	
	@Override
	public void onDisable() {
		plugin = null;
	}
	
    @Override
    public BiomeProvider getDefaultBiomeProvider(String worldName, String id) {
        return new SimpleBiomeProvider();
    }
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
	    return new TestWorldGen();
	}

}
