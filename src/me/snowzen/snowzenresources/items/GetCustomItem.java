package me.snowzen.snowzenresources.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.snowzen.snowzenresources.Configs.Config;

public class GetCustomItem extends Config {
	public ItemStack getItemFromConfig(String itemName) {
		Material mat = Material.getMaterial(plugin.getConfig().getString("items." + itemName + ".type"));
		String name = plugin.getConfig().getString("items." + itemName + ".name");
		@SuppressWarnings("unchecked")
		List<String> lore = (List<String>) plugin.getConfig().getList("items." + itemName + ".lore");
		
		ItemStack is = new ItemStack(mat);
		ItemMeta meta = is.getItemMeta();
		
		meta.setLore(lore);
		meta.setDisplayName(name);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		
		is.setItemMeta(meta);
		
		return is;
	}
}
