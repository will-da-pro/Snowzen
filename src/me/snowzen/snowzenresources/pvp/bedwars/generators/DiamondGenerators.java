package me.snowzen.snowzenresources.pvp.bedwars.generators;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class DiamondGenerators extends Generator {
	public DiamondGenerators(double[][] coordinates, World world, Plugin plugin) {
		super(coordinates, world, plugin);
		
		super.genText = "Diamond Generator";
		super.genItem = new ItemStack(Material.DIAMOND);
		
		super.spawnTime.put(360, 120);
		super.spawnTime.put(300, 100);
		super.spawnTime.put(300, 60);
		super.spawnTime.put(0, 30);
	}
}
