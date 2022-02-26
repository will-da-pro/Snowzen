package me.snowzen.snowzenresources.items;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import de.tr7zw.nbtapi.NBTItem;

public class ItemAbility {
	public static void itemAbility(PlayerInteractEvent event) {
		@SuppressWarnings("unused")
		Player p = event.getPlayer();
		ItemStack item = event.getItem();
		NBTItem nbti = new NBTItem(item);
		
		if (nbti.hasKey("custom.ability")) {
			
		}
	}
}
