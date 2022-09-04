package me.snowzen.snowzenresources.items.bedwars;
import java.util.Arrays;
import java.util.HashMap;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTCompoundList;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTListCompound;

public class BedwarsItems {
	static HashMap<String, ItemStack> items = new HashMap<String, ItemStack>();
	
	enum Ability {
		NONE
	}
	
	public HashMap<String, ItemStack> createItems(String team) {
		registerItem("Wool", GUIType.BUYABLE, Material.valueOf(team + "_WOOL"), (short)4, Material.IRON_INGOT.toString(), (short)16, team);
		
		return items;
	}
	
	private static void registerItem(String name, GUIType type, Material mat, Short price, String buyMat, Short amount, String team, String... lore) {
		ItemStack item = new ItemStack(mat, amount); 
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName("Wool");
		meta.setLore(Arrays.asList(lore));
		
		item.setItemMeta(meta);
		
		NBTItem nbti = new NBTItem(item);
		NBTCompound nbtComp = nbti.addCompound("shop");
		
		// 1: buyable item, 2: menu item
		nbtComp.setString("guitype", type.toString());
		nbtComp.setShort("price", price);
		nbtComp.setString("material", buyMat);
		
		NBTCompound custom = nbti.addCompound("custom");
		custom.setString("id", name);
		
		nbti.setBoolean("Unbreakable", true);
		
		item = nbti.getItem();
		
		items.put(name, item);
	}
	
	@SuppressWarnings("unused")
	private static void registerItem(String name, GUIType type, Material mat, Short price, String buyMat, Short amount, Byte damage, String team, String... lore) {
		ItemStack item = new ItemStack(mat, amount); 
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName("Wool");
		meta.setLore(Arrays.asList(lore));
		
		item.setItemMeta(meta);
		
		NBTItem nbti = new NBTItem(item);
		NBTCompound nbtComp = nbti.addCompound("shop");
		
		nbtComp.setString("guitype", type.toString());
		nbtComp.setShort("price", price);
		nbtComp.setString("material", buyMat);
		
		NBTCompound custom = nbti.addCompound("custom");
		custom.setString("id", name);
		
		NBTCompoundList attribute = nbti.getCompoundList("AttributeModifiers");
        NBTListCompound mod1 = attribute.addCompound();
        mod1.setByte("Amount", damage);
        mod1.setString("AttributeName", "generic.attack_damage");
        mod1.setString("Name", "generic.attack_damage");
        mod1.setString("Slot", "mainhand");
        mod1.setInteger("Operation", 0);
        mod1.setInteger("UUIDLeast", 59664);
        mod1.setInteger("UUIDMost", 31453);
		
		nbti.setBoolean("Unbreakable", true);
		
		item = nbti.getItem();
		
		items.put(name, item);

	}
	
	@SuppressWarnings("unused")
	private static void registerItem(String name, GUIType type, Material mat, Short price, String buyMat, Short amount, Ability ability, String team, String... lore) {
		ItemStack item = new ItemStack(mat, amount); 
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName("Wool");
		meta.setLore(Arrays.asList(lore));
		
		item.setItemMeta(meta);
		
		NBTItem nbti = new NBTItem(item);
		NBTCompound nbtComp = nbti.addCompound("shop");
		
		// 1: buyable item, 2: menu item
		nbtComp.setString("guitype", type.toString());
		nbtComp.setShort("price", price);
		nbtComp.setString("material", buyMat);
		
		NBTCompound custom = nbti.addCompound("custom");
		custom.setString("id", name);
		custom.setString("ability", ability.toString());
		
		nbti.setBoolean("Unbreakable", true);
		
		item = nbti.getItem();
		
		items.put(name, item);

	}
	
	@SuppressWarnings("unused")
	private static void registerItem(String name, GUIType type, Material mat, Short price, String buyMat, Short amount, Ability ability, Byte damage, String team, String... lore) {
		ItemStack item = new ItemStack(mat, amount); 
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName("Wool");
		meta.setLore(Arrays.asList(lore));
		
		item.setItemMeta(meta);
		
		NBTItem nbti = new NBTItem(item);
		NBTCompound nbtComp = nbti.addCompound("shop");
		
		// 1: buyable item, 2: menu item
		nbtComp.setString("guitype", type.toString());
		nbtComp.setShort("price", price);
		nbtComp.setString("material", buyMat);
		
		NBTCompound custom = nbti.addCompound("custom");
		custom.setString("id", name);
		custom.setString("ability", ability.toString());
		
		NBTCompoundList attribute = nbti.getCompoundList("AttributeModifiers");
        NBTListCompound mod1 = attribute.addCompound();
        mod1.setByte("Amount", damage);
        mod1.setString("AttributeName", "generic.attack_damage");
        mod1.setString("Name", "generic.attack_damage");
        mod1.setString("Slot", "mainhand");
        mod1.setInteger("Operation", 0);
        mod1.setInteger("UUIDLeast", 59664);
        mod1.setInteger("UUIDMost", 31453);

        nbti.setBoolean("Unbreakable", true);
		
		item = nbti.getItem();
		
		items.put(name, item);

	}
	
	public static ItemStack getItem(String item) {
		ItemStack toReturn = items.get(item);
		
		return toReturn;
	}
}
