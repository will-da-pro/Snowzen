package me.snowzen.snowzenresources.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import me.snowzen.snowzenresources.Configs.Config;

public class GetCustomItem extends Config {
	public static ItemStack getItemFromConfig(String itemName) {
		Material mat = Material.getMaterial(plugin.getConfig().getString("items." + itemName + ".type"));
		String name = plugin.getConfig().getString("items." + itemName + ".name");
		@SuppressWarnings("unchecked")
		List<String> lore = (List<String>) plugin.getConfig().getList("items." + itemName + ".lore");
		Integer dmg = plugin.getConfig().getInt("items." + itemName + ".damage");
		
		ItemStack is = new ItemStack(mat);
		ItemMeta meta = is.getItemMeta();
		
		meta.setLore(lore);
		meta.setDisplayName(name);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		is.setItemMeta(meta);
		
		NBTItem nbti = new NBTItem(is);
		nbti.setString("customItem", itemName);
		is = NBTItem.convertNBTtoItem(nbti);
		
		NBTCompound custom = nbti.addCompound("custom");
		custom.setString("id", itemName);
		custom.setInteger("damage", dmg);
		
		is = nbti.getItem();
		return is;
	}
}
