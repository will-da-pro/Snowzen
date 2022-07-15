package me.snowzen.snowzenresources.pvp.bedwars;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import me.snowzen.snowzenresources.Configs.Config;
import me.snowzen.snowzenresources.pvp.bedwars.generators.BaseGenerators;
import me.snowzen.snowzenresources.pvp.bedwars.generators.DiamondGenerators;

public class BedwarsWorld extends Config {
	private String gamemode;
	private Plugin plugin;
	
	public BedwarsWorld(String gamemode, String name, Plugin plugin) {
		this.gamemode = gamemode;
		this.plugin = plugin;
	}
	
	public void createWorld() {
		@SuppressWarnings("unchecked")
		List<String> worlds = (List<String>) plugin.getConfig().getConfigurationSection("worlds." + this.gamemode);
		Random rand = new Random();
		
		short length;
		
		switch (this.gamemode) {
			case ("solos"):
				length = 16;
				break;
			case ("duos"):
				length = 8;
				break;
			case ("trios"):
				length = 4;
				break;
			case ("squads"):
				length = 4;
				break;
			case ("4v4"):
				length = 2;
				break;
			default:
				length = 16;
				Bukkit.getLogger().warning("Error in createWorld");
				break;
		}
		String worldName = worlds.get(rand.nextInt(worlds.size()));
		ConfigurationSection configWorld = plugin.getConfig().getConfigurationSection("worlds." + this.gamemode + worldName);
		World world = Bukkit.getWorld(worldName);
		double[][] baseGens = new double[length][3];
		double[][] diamondGens = new double[4][3];
		double[][] emeraldGens = new double[4][3];
		
		// Base generators
		for (short i = 0; i < length; i++) {
			List<Short> coords = configWorld.getShortList("generators.base." + i);
			for (short n = 0; n < coords.size(); n++) {
				baseGens[i][n] = coords.get(n);
			}
		}
		
		// Diamond generators
		for (short i = 0; i < 4; i++) {
			List<Short> coords = configWorld.getShortList("generators.diamond." + i);
			for (short n = 0; n < coords.size(); n++) {
				diamondGens[i][n] = coords.get(n);
			}
		}
		
		// Emerald generators
		for (short i = 0; i < 4; i++) {
			List<Short> coords = configWorld.getShortList("generators.emerald." + i);
			for (short n = 0; n < coords.size(); n++) {
				emeraldGens[i][n] = coords.get(n);
			}
		}
		
		// Generator objects
		@SuppressWarnings("unused")
		BaseGenerators baseGen = new BaseGenerators(baseGens, world);
		@SuppressWarnings("unused")
		DiamondGenerators diamondGen = new DiamondGenerators(diamondGens, world, plugin);
	}
	
	public interface bedwarsGames {
		public static String[][] lobbies = {};
	}
}
