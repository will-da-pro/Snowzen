package me.snowzen.snowzenresources.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.snowzen.snowzenresources.Main;

public class HelloCommand implements CommandExecutor{
	
	private Main plugin;
	
	public HelloCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("hello").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players may execute this command");
			return true;
		}
		Player p = (Player) sender;
		
		if (p.hasPermission("snowzen.hello")) {
			String name = plugin.getConfig().getString("players." + p.getDisplayName() + ".name");
			p.sendMessage(name);
			return true;
		} else {
			p.sendMessage("You do not have permission to use this command");
		}
		
		return false;
	}
	
}
