package me.snowzen.snowzenresources.pvp.bedwars;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import me.snowzen.snowzenresources.Configs.Config;

public class BedwarsWorld extends Config {
	private String name;
	private String gamemode;
	
	public BedwarsWorld(String gamemode, String name) {
		this.gamemode = gamemode;
		this.name = name;
	}
	
	@Deprecated
	private File getRandomSchematic() {
		@SuppressWarnings("unchecked")
		List<String> schematics = (List<String>) plugin.getConfig().getList("worlds." + this.gamemode);
		Random rand = new Random();
		
		String strPath = schematics.get(rand.nextInt(schematics.size()));
		
		File file = new File(plugin.getConfig().getString(strPath));
		
		return file;
	}
	
	public void createWorld() {
		//File file = getRandomSchematic();
		
		//WorldCreator wc = new WorldCreator(this.name);

		//wc.type(WorldType.FLAT);
		//wc.generatorSettings("2;0;1;");

		//World world = wc.createWorld();
		//Vector loc = new Vector(0, 0, 0);
		
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
		
		ConfigurationSection world = plugin.getConfig().getConfigurationSection("worlds." + this.gamemode + worlds.get(rand.nextInt(worlds.size())));
		short[][] baseGens = new short[length][2];
		short[][] diamondGens = new short[4][2];
		short[][] emeraldGens = new short[4][2];
		
		// Base generators
		for (short i = 0; i < length; i++) {
			List<Short> coords = world.getShortList("generators.base." + i);
			for (short n = 0; n < coords.size(); n++) {
				baseGens[i][n] = coords.get(n);
			}
		}
		
		// Diamond generators
		for (short i = 0; i < 4; i++) {
			List<Short> coords = world.getShortList("generators.diamond." + i);
			for (short n = 0; n < coords.size(); n++) {
				diamondGens[i][n] = coords.get(n);
			}
		}
		
		// Emerald generators
		for (short i = 0; i < 4; i++) {
			List<Short> coords = world.getShortList("generators.emerald." + i);
			for (short n = 0; n < coords.size(); n++) {
				emeraldGens[i][n] = coords.get(n);
			}
		}
	}
	
	public interface bedwarsGames {
		public static String[][] lobbies = {};
	}
}
