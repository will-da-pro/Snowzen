package me.snowzen.snowzenresources.entities.bedwars;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Villager;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import me.snowzen.snowzenresources.Main;

public class PersonalShop {
	@SuppressWarnings("unused")
	private Main plugin;
	private World world;
	private Location location;
	public PersonalShop(Main plugin, World world, Location location) {
		this.plugin = plugin;
		this.world = world;
		this.location = location;
	}    
	public void spawnEntity() {
		LivingEntity entity = (LivingEntity)world.spawnEntity(location, EntityType.VILLAGER);
		Villager shop = (Villager)entity;
		MetadataValue meta = new FixedMetadataValue(plugin, 1);
		
		shop.setCustomName("§cItem Shop");
		shop.setCustomNameVisible(true);
		shop.setMetadata("shop", meta);
		return;
	}
}