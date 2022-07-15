package me.snowzen.snowzenresources.pvp.bedwars.generators;

import java.util.concurrent.TimeUnit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.google.common.base.Stopwatch;

import me.filoghost.holographicdisplays.api.HolographicDisplaysAPI;
import me.filoghost.holographicdisplays.api.hologram.Hologram;
import me.snowzen.snowzenresources.pvp.bedwars.BedwarsHologram;

public class DiamondGenerators extends Thread {
	private double[][] gens;
	private World world;
	public Stopwatch watch;
	private Plugin plugin;
	private Hologram[] holos;
	
	public DiamondGenerators(double[][] coordinates, World world, Plugin plugin) {
		this.gens = coordinates;
		this.world = world;
		this.plugin = plugin;
	}
	
	public void runGenerators() throws Exception { 
		holos = new Hologram[gens.length];
		HolographicDisplaysAPI api = HolographicDisplaysAPI.get(plugin);
		BedwarsHologram bedHolo = new BedwarsHologram(holos, this);
		
		for (short i = 0; i < gens.length; i++) {
			Location loc = new Location(world, gens[i][1], gens[i][2], gens[i][3]);
			Hologram hologram = api.createHologram(loc);
			
			hologram.getLines().appendItem(new ItemStack(Material.DIAMOND));
			hologram.getLines().appendText("Diamond Generator");
			hologram.getLines().appendText("");
			
			holos[i] = hologram;
		}
		
		watch.start();
		bedHolo.start();
		
		while (watch.elapsed(TimeUnit.SECONDS) < 150) {
			spawnItems();
			wait(100 * 60);
		} 
		
		while (watch.elapsed(TimeUnit.SECONDS) < 450) {
			spawnItems();
			wait(100 * 30);
		}
	}
	
	private void spawnItems() {
		for (short i = 0; i < gens.length; i++) {
			ItemStack item = new ItemStack(Material.DIAMOND);
			Location loc = new Location(world, gens[i][1], gens[i][2], gens[i][3]);
			world.dropItemNaturally(loc, item);
		}
	}
}
