package me.snowzen.snowzenresources;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.Bukkit;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import me.snowzen.snowzenresources.Configs.Config;
import me.snowzen.snowzenresources.commands.HelloCommand;
import me.snowzen.snowzenresources.commands.SnowGive;
import me.snowzen.snowzenresources.customWorldGen.TestWorldGen;
//import me.snowzen.snowzenresources.commands.snowgive;
import me.snowzen.snowzenresources.customWorldGen.Biomes.SimpleBiomeProvider;
import me.snowzen.snowzenresources.skills.Skills;

public class Main extends JavaPlugin{
	
	public static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new Skills(), this);
		new HelloCommand(this);
		new SnowGive(this);
		Config.startup();
	}
	
	@Override
	public void onDisable() {
		plugin = null;
	}
	
	@Nullable
    @Override
    public BiomeProvider getDefaultBiomeProvider(@Nonnull String worldName, @Nullable String id) {
        return new SimpleBiomeProvider();
    }
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
	    return new TestWorldGen();
	}

}
