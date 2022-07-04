package me.snowzen.snowzenresources.commands;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.snowzen.snowzenresources.Main;

public class GetIP implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public GetIP(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("hello").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		try {
			System.out.print(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
}
