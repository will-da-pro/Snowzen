package me.snowzen.snowzenresources.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTCompoundList;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTListCompound;
import me.snowzen.snowzenresources.Configs.Config;

public class GetCustomItem extends Config {
	public static ItemStack getItemFromConfig(String itemName) {
		Material mat = Material.getMaterial(plugin.getConfig().getString("items." + itemName + ".type"));
		String name = plugin.getConfig().getString("items." + itemName + ".name");
		@SuppressWarnings("unchecked")
		List<String> lore = (List<String>) plugin.getConfig().getList("items." + itemName + ".lore");
		Integer dmg = plugin.getConfig().getInt("items." + itemName + ".damage");
		String ability = plugin.getConfig().getString("items." + itemName + ".ability");
		
		ItemStack is = new ItemStack(mat);
		ItemMeta meta = is.getItemMeta();
		
		meta.setLore(lore);
		meta.setDisplayName(name);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		is.setItemMeta(meta);
		
		NBTItem nbti = new NBTItem(is);
		
		NBTCompound custom = nbti.addCompound("custom");
		custom.setString("id", itemName);
		custom.setInteger("damage", dmg);
		custom.setString("ability", ability);
		
		NBTCompoundList attribute = nbti.getCompoundList("AttributeModifiers");
        NBTListCompound mod1 = attribute.addCompound();
        mod1.setByte("Amount", dmg.byteValue());
        mod1.setString("AttributeName", "generic.attack_damage");
        mod1.setString("Name", "generic.attack_damage");
        mod1.setString("Slot", "mainhand");
        mod1.setInteger("Operation", 0);
        mod1.setInteger("UUIDLeast", 59664);
        mod1.setInteger("UUIDMost", 31453);

        nbti.setBoolean("Unbreakable", true);
        
		is = nbti.getItem();
		return is;
	}
}
