package me.snowzen.snowzenresources.Configs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import me.snowzen.snowzenresources.Main;

public class Config {
	public static Main plugin = Main.plugin;
	public static void startup() {
		plugin.saveDefaultConfig();
	}
	@EventHandler
	public static void initPlayerConfig(Player plr) {
		Bukkit.getLogger().info("Initialising Player Config");
		String dir = "players." + plr.getName();
		plugin.getConfig().set(dir + ".name" , plr.getName());
		plugin.getConfig().addDefault(dir + ".skills.combat.xp" , 0);
		plugin.getConfig().addDefault(dir + ".skills.combat.level" , 0);
		plugin.getConfig().addDefault(dir + ".skills.mining.xp" , 0);
		plugin.getConfig().addDefault(dir + ".skills.mining.level" , 0);
		plugin.getConfig().addDefault(dir + ".skills.foraging.xp" , 0);
		plugin.getConfig().addDefault(dir + ".skills.foraging.level" , 0);
		plugin.getConfig().addDefault(dir + ".skills.alchemy.xp" , 0);
		plugin.getConfig().addDefault(dir + ".skills.alchemy.level" , 0);
		plugin.getConfig().addDefault(dir + ".skills.enchanting.xp" , 0);
		plugin.getConfig().addDefault(dir + ".skills.enchanting.level" , 0);
		plugin.getConfig().addDefault(dir + ".skills.magic.xp" , 0);
		plugin.getConfig().addDefault(dir + ".skills.magic.level" , 0);
		plugin.getConfig().addDefault(dir + ".skills.carpentry.xp" , 0);
		plugin.getConfig().addDefault(dir + ".skills.carpentry.level" , 0);
		plugin.saveConfig();
		Bukkit.getLogger().info("Initialized player config in " + dir);
		
	}
}
