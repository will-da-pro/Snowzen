package me.snowzen.snowzenresources.Events;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.snowzen.snowzenresources.Configs.Config;
import me.snowzen.snowzenresources.skills.Skills;

public class Events implements Listener {
	public static Server plugin;
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Skills.checkMining(event);
		Skills.checkForaging(event);
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		Config.initPlayerConfig(p);
	}
	@EventHandler
	public void onEnchant(EnchantItemEvent event) {
		Skills.checkEnchant(event);
	}
	@EventHandler
	public void onBrew(BrewEvent event) {
		Skills.checkBrew(event);
	}
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (!event.getCause().equals(DamageCause.ENTITY_ATTACK)) {
			return;
		}
	}
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerUse(PlayerInteractEvent event){
	    
	}
}
