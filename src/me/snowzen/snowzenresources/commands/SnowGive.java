package me.snowzen.snowzenresources.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.snowzen.snowzenresources.Main;
import me.snowzen.snowzenresources.items.GetCustomItem;

public class SnowGive extends GetCustomItem implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public SnowGive(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("snowgive").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players may execute this command");
			return true;
		}
		Player p = (Player) sender;
		
		if (p.hasPermission("snowzen.snowgive")) {
			ItemStack item = GetCustomItem.getItemFromConfig(args[1]);
			String playerName = args[0];
			Player target = sender.getServer().getPlayerExact(playerName);
			if (target == null) { //check whether the player is online
			    sender.sendMessage("Player " + playerName + " is not online.");
			    return true;
			}
			target.getInventory().addItem(item);
			return true;
		} else {
			p.sendMessage("You do not have permission to use this command");
		}
		
		return false;
	}
	
}
