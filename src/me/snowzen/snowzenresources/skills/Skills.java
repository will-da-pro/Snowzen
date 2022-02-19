package me.snowzen.snowzenresources.skills;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.BrewEvent;

import me.snowzen.snowzenresources.Main;

public class Skills implements Listener {
	public static void checkMining(BlockBreakEvent br) {
		if (br.isCancelled()) {
			return;
		}
		if (br.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
			return;
		}
		if (!br.isDropItems()) {
			return;
		}
		Material block = br.getBlock().getType();
		int stone = 1, deepslate = 5, diorite = 2, granite = 2, andesite = 2, coal = 5, iron = 15, gold = 30, redstone = 20, diamond = 50, emerald = 70;
		Player player = br.getPlayer();
	 
		Integer xp = Main.plugin.getConfig().getInt("players." + player.getName() + ".skills.mining.xp");
		String path = "players." + player.getName() + ".skills.mining.xp";
		if (block == Material.STONE) {
			Main.plugin.getConfig().set(path, xp + stone);
		}
		else if (block == Material.DEEPSLATE) {
			Main.plugin.getConfig().set(path, xp + deepslate);
		}
		else if (block == Material.DIORITE) {
			Main.plugin.getConfig().set(path, xp + diorite);
		}
		else if (block == Material.ANDESITE) {
			Main.plugin.getConfig().set(path, xp + andesite);
		}
		else if (block == Material.GRANITE) {
			Main.plugin.getConfig().set(path, xp + granite);
		}
		else if (block == Material.COAL_ORE || block == Material.DEEPSLATE_COAL_ORE) {
			Main.plugin.getConfig().set(path, xp + coal);
		}
		else if (block == Material.IRON_ORE || block == Material.DEEPSLATE_IRON_ORE) {
			Main.plugin.getConfig().set(path, xp + iron);
		}
		else if (block == Material.REDSTONE_ORE || block == Material.DEEPSLATE_REDSTONE_ORE) {
			Main.plugin.getConfig().set(path, xp + redstone);
		}
		else if (block == Material.GOLD_ORE || block == Material.DEEPSLATE_GOLD_ORE) {
			Main.plugin.getConfig().set(path, xp + gold);
		}
		else if (block == Material.DIAMOND_ORE || block == Material.DEEPSLATE_DIAMOND_ORE) {
			Main.plugin.getConfig().set(path, xp + diamond);
		}
		else if (block == Material.EMERALD_ORE || block == Material.DEEPSLATE_EMERALD_ORE) {
			Main.plugin.getConfig().set(path, xp + emerald);
		}
		else {
			return;
		}
		player.sendMessage(xp.toString());
		Main.plugin.saveConfig();
	}
	public static void checkForaging(BlockBreakEvent br) {
		if (br.isCancelled()) {
			return;
		}
		Material block = br.getBlock().getType();
		int oak = 1, birch = 2, acacia = 2, spruce = 3, jungle = 4, dark_oak = 5;
		
		Player player = br.getPlayer();
		Integer xp = Main.plugin.getConfig().getInt("players." + player.getName() + ".skills.foraging.xp");
		String path = "players." + player.getName() + ".skills.foraging.xp";
		
		if (block == Material.OAK_LOG) {
			Main.plugin.getConfig().set(path, xp + oak);
		}
		else if (block == Material.BIRCH_LOG) {
			Main.plugin.getConfig().set(path, xp + birch);
		}
		else if (block == Material.ACACIA_LOG) {
			Main.plugin.getConfig().set(path, xp + acacia);
		}
		else if (block == Material.SPRUCE_LOG) {
			Main.plugin.getConfig().set(path, xp + spruce);
		}
		else if (block == Material.JUNGLE_LOG) {
			Main.plugin.getConfig().set(path, xp + jungle);
		}
		else if (block == Material.DARK_OAK_LOG) {
			Main.plugin.getConfig().set(path, xp + dark_oak);
		}
		else {
			return;
		}
		player.sendMessage(xp.toString());
		Main.plugin.saveConfig();
	}
	public static void checkEnchant(EnchantItemEvent br) {
		if (br.isCancelled()) {
			return;
		}

		Player player = br.getEnchanter();
		Integer xpToGive = (br.getExpLevelCost() * 5) * br.getEnchantsToAdd().size();
		Integer xp = Main.plugin.getConfig().getInt("players." + player.getName() + ".skills.enchanting.xp");
		String path = "players." + player.getName() + ".skills.enchanting.xp";
		
		Main.plugin.getConfig().set(path, xp + xpToGive);
	}
	public static void checkBrew(BrewEvent br) {
		if (br.isCancelled()) {
			return;
		}
	}
}
