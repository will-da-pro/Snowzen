package me.snowzen.snowzenresources.items.bedwars;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;

public class Wool {
	public static ItemStack getItem(Material woolType, short price, String material) {
		ItemStack item = new ItemStack(woolType, 16); 
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		lore.add("Use this to bridge to your enemies!");
		
		meta.setDisplayName("Wool");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		NBTItem nbti = new NBTItem(item);
		NBTCompound nbtComp = nbti.addCompound("shop");
		
		// 1: buyable item, 2: menu item
		nbtComp.setShort("guitype", (short) 1);
		nbtComp.setShort("price", price);
		nbtComp.setString("material", material);
		
		item = nbti.getItem();
		
		return item;
	}
	
	public static Material getWoolMaterial(String team) {
		switch (team) {
			case "white":
				return Material.WHITE_WOOL;
			case "red":
				return Material.RED_WOOL;
			case "blue":
				return Material.BLUE_BED;
			case "gray":
				return Material.GRAY_WOOL;
			case "orange":
				return Material.ORANGE_WOOL;
			case "cyan":
				return Material.CYAN_WOOL;
			case "lime":
				return Material.LIME_WOOL;
			case "pink":
				return Material.PINK_WOOL;
			default:
				Bukkit.getLogger().warning("Invalid team at getWoolMaterial");
				return Material.WHITE_WOOL;
		}
	}
}
