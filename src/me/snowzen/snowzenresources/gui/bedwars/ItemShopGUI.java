package me.snowzen.snowzenresources.gui.bedwars;

import me.snowzen.snowzenresources.items.bedwars.Wool;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;

public class ItemShopGUI implements Listener {
	public static Inventory getGUI(String team, short page) {
		Inventory inv = Bukkit.createInventory(null, 9, "Item Shop");
		
		switch (page) {
			case 1:
				ItemStack woolItem = Wool.getItem(Wool.getWoolMaterial(team), (short) 16, "IRON_INGOT");
				
				inv.addItem(woolItem);
				break;
			case 2:
				ItemStack placeholder = Wool.getItem(Wool.getWoolMaterial(team), (short) 16, "IRON_INGOT");
				
				inv.addItem(placeholder);
				break;
		}
		
		return inv;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		ItemStack item = event.getCurrentItem();
		NBTItem nbt = new NBTItem(item);
		NBTCompound comp = nbt.getCompound("bedwars");
		Inventory inv = event.getInventory();
		Player plr = Bukkit.getPlayer(event.getWhoClicked().getName());
		
		if (comp.hasKey("guitype")) {
			short type = comp.getShort("guitype");
			short price = comp.getShort("price");
			Material material = Material.valueOf(comp.getString("material"));
			switch (type) {
				case 0:
					event.setCancelled(true);
					break;
				case 1:
					event.setCancelled(true);
					if (inv.contains(material, price)) {
						inv.removeItem(new ItemStack(material, price));
						
						ItemStack giveItem = item;
						NBTItem newNBT = new NBTItem(giveItem);
						NBTCompound newComp = newNBT.getCompound("bedwars");
					
						newComp.removeKey("guitype");
						newComp.removeKey("price");
						newComp.removeKey("material");
					
						giveItem = newNBT.getItem();
					
						ItemMeta meta = giveItem.getItemMeta();
						List<String> lore = meta.getLore();
					
						lore.remove(lore.size() - 1);
					
						meta.setLore(lore);
						item.setItemMeta(meta);
						
						inv.addItem(item);
					}
					break;
				case 2:
					event.setCancelled(true);
					short page = comp.getShort("page");
					Scoreboard score = Bukkit.getScoreboardManager().getMainScoreboard();
					
					Team team = score.getEntryTeam(plr.getDisplayName());
					
					plr.openInventory(ItemShopGUI.getGUI(team.getName(), page));
					
					break;
			}
		}
	}
}
