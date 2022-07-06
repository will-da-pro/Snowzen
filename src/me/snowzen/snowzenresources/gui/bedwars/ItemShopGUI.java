package me.snowzen.snowzenresources.gui.bedwars;

import me.snowzen.snowzenresources.items.bedwars.Wool;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemShopGUI {
	public Inventory getGUI(String team) {
		Inventory inv = Bukkit.createInventory(null, 9, "Item Shop");
		
		ItemStack woolItem = Wool.getItem(Wool.getWoolMaterial(team));
		
		inv.addItem(woolItem);
		
		return inv;
	}
}
