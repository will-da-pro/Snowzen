package me.snowzen.snowzenresources;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.snowzen.snowzenresources.Configs.Config;

public class JoinEvent implements Listener {
	public static Server plugin;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
    	Player p = event.getPlayer();
    	//if(!p.hasPlayedBefore()) {
    		Config.initPlayerConfig(p);
    	//}
    }
}
