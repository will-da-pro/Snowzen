package me.snowzen.snowzenresources.pvp.bedwars.generators;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class BaseGenerators {
	private double[][] gens;
	private World world;
	
	public BaseGenerators(double[][] coordinates, World world) {
		this.gens = coordinates;
		this.world = world;
	}
	
	public void runGenerators() throws Exception {
		while (true) {
			spawnItems();
			wait(50);
		}
	}
	
	private void spawnItems() {
		for (short i = 0; i < this.gens.length; i++) {
			double rand = Math.random();
			ItemStack item;
			if (rand > 0.2) {
				item = new ItemStack(Material.IRON_INGOT);
			} else {
				item = new ItemStack(Material.GOLD_INGOT);
			}
			Location loc = new Location(world, gens[i][1], gens[i][2], gens[i][3]);
			world.dropItemNaturally(loc, item);
		}
	}
}
