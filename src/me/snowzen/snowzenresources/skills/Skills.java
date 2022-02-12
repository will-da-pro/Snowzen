package me.snowzen.snowzenresources.skills;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.snowzen.snowzenresources.Main;

public class Skills implements Listener {
	@EventHandler(priority = EventPriority.HIGH)
	public void onBreak(BlockBreakEvent br) {
		if (br.isCancelled()) {
			return;
		}
		Material block = br.getBlock().getType();
		if (block != Material.STONE & 
			 block != Material.COAL_ORE &
			 block != Material.DEEPSLATE_COAL_ORE &
			 block != Material.DEEPSLATE_IRON_ORE &
			 block != Material.IRON_ORE & 
			 block != Material.REDSTONE_ORE & 
			 block != Material.DEEPSLATE_REDSTONE_ORE &
			 block != Material.GOLD_ORE & 
			 block != Material.DEEPSLATE &
			 block != Material.DEEPSLATE_GOLD_ORE &
			 block != Material.DEEPSLATE_DIAMOND_ORE &
			 block != Material.DIAMOND_ORE & 
			 block != Material.EMERALD_ORE & 
			 block != Material.DEEPSLATE_EMERALD_ORE &
			 block != Material.DIORITE & 
			 block != Material.GRANITE &
			 block != Material.ANDESITE ) {
			br.getPlayer().sendMessage("Wrong Block");
		 return;
		}
		int stone = 1, deepslate = 5, diorite = 2, granite = 2, andesite = 2, coal = 5, iron = 15, gold = 30, redstone = 20, diamond = 50, emerald = 70;
		Player player = br.getPlayer();
		player.sendMessage("players." + player.getName() + ".skills.mining.xp");
	 
		Integer xp = Main.plugin.getConfig().getInt("players." + player.getName() + ".skills.mining.xp");
		if (block == Material.STONE) {
			Main.plugin.getConfig().set("players." + player.getName() + ".skills.mining.xp", xp + stone);
		}
		else if (block == Material.DEEPSLATE) {
			Main.plugin.getConfig().set("players." + player.getName() + ".skills.mining.xp", xp + deepslate);
		}
		else if (block == Material.DIORITE) {
			Main.plugin.getConfig().set("players." + player.getName() + ".skills.mining.xp", xp + diorite);
		}
		else if (block == Material.ANDESITE) {
			Main.plugin.getConfig().set("players." + player.getName() + ".skills.mining.xp", xp + andesite);
		}
		else if (block == Material.GRANITE) {
			Main.plugin.getConfig().set("players." + player.getName() + ".skills.mining.xp", xp + granite);
		}
		else if (block == Material.COAL_ORE || block == Material.DEEPSLATE_COAL_ORE) {
			Main.plugin.getConfig().set("players." + player.getName() + ".skills.mining.xp", xp + coal);
		}
		else if (block == Material.IRON_ORE || block == Material.DEEPSLATE_IRON_ORE) {
			Main.plugin.getConfig().set("players." + player.getName() + ".skills.mining.xp", xp + iron);
		}
		else if (block == Material.REDSTONE_ORE || block == Material.DEEPSLATE_REDSTONE_ORE) {
			Main.plugin.getConfig().set("players." + player.getName() + ".skills.mining.xp", xp + redstone);
		}
		else if (block == Material.GOLD_ORE || block == Material.DEEPSLATE_GOLD_ORE) {
			Main.plugin.getConfig().set("players." + player.getName() + ".skills.mining.xp", xp + gold);
		}
		else if (block == Material.DIAMOND_ORE || block == Material.DEEPSLATE_DIAMOND_ORE) {
			Main.plugin.getConfig().set("players." + player.getName() + ".skills.mining.xp", xp + diamond);
		}
		else if (block == Material.EMERALD_ORE || block == Material.DEEPSLATE_EMERALD_ORE) {
			Main.plugin.getConfig().set("players." + player.getName() + ".skills.mining.xp", xp + emerald);
		}
		player.sendMessage("Mined 1 " + block.name());
		player.sendMessage(Integer.toString(xp));
		Main.plugin.saveConfig();
	}
}
