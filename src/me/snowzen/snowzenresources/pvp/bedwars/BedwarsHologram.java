package me.snowzen.snowzenresources.pvp.bedwars;

import java.util.concurrent.TimeUnit;

import me.filoghost.holographicdisplays.api.hologram.Hologram;
import me.snowzen.snowzenresources.pvp.bedwars.generators.DiamondGenerators;

public class BedwarsHologram extends Thread {
	Hologram[] holos;
	DiamondGenerators gens;
	
	public BedwarsHologram(Hologram[] holograms, DiamondGenerators generators) {
		this.holos = holograms;
		this.gens = generators;
	}
	
	public void run() {
		while (true) {
			for (short i = 0; i < holos.length; i++) {
				Hologram holo = holos[i];
				holo.getLines().remove(holo.getLines().size() - 1);
				holo.getLines().appendText(Long.toString(gens.watch.elapsed(TimeUnit.SECONDS)));
			}
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
