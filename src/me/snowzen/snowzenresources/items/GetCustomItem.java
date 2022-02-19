package me.snowzen.snowzenresources.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.snowzen.snowzenresources.Configs.Config;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

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
		NBTEntity nbtent = new NBTEntity(zombie); //Only for vanilla tags!
		NBTTileEntity tent = new NBTTileEntity(block.getState()); //Only for vanilla tags!
		NBTFile file = new NBTFile(new File(getDataFolder(), "test.nbt"));
		NBTContainer container =  new NBTContainer(json); //Parse in json
		
		return is;
	}
}
