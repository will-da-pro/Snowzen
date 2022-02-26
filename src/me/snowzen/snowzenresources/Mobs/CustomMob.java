package me.snowzen.snowzenresources.Mobs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import me.snowzen.snowzenresources.Main;

public class CustomMob implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	public CustomMob(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("snowspawn").setExecutor(this);
	}
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String [] args){
		if(sender instanceof Player){
			Player p = ((Player) sender).getPlayer();
               
			LivingEntity mob = (LivingEntity)p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
			Zombie z = (Zombie)mob;
               
			z.setCustomName("§cZombie Custom");
			z.setCustomNameVisible(true);
			z.setBaby(false);
			z.setMaxHealth(50);
			z.setHealth(50);
			
			sender.sendMessage("§6§lMOBS: §fMob custom spawned!");
			return true;
		}
		return false;	
	}
}