package me.snowzen.snowzenresources.items.abilitites;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class AxeAoe {
	public static void ability(Player plr, Integer damage) {
		Integer entities = 0;
		for (Entity en : plr.getNearbyEntities(5, 5, 5))
		{
		    if (!en.isInvulnerable() && !en.isDead()) {
		    	((LivingEntity) en).damage(damage);
		    	entities ++;
		    }
		}
		if (entities != 0) {
			plr.sendMessage("Hit " + entities.toString() + " enemies for " + entities * damage + " damage");
		}
	}
}
