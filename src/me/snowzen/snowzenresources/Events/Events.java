package me.snowzen.snowzenresources.Events;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.snowzen.snowzenresources.Configs.Config;
import me.snowzen.snowzenresources.skills.Skills;

public class Events implements Listener {
	public static Server plugin;
	@EventHandler
	public void onBreak(BlockBreakEvent br) {
		Skills.checkMining(br);
	}
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
    	Player p = event.getPlayer();
    	Config.initPlayerConfig(p);
    }
}
