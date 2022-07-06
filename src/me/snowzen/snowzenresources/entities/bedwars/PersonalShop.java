package me.snowzen.snowzenresources.entities.bedwars;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import me.snowzen.snowzenresources.Main;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.SkinTrait;

public class PersonalShop {
	@SuppressWarnings("unused")
	private Main plugin;
	private Location location;
	private String skin;
	public PersonalShop(Main plugin, String skin, Location location) {
		this.plugin = plugin;
		this.location = location;
		this.skin = skin;
	}    
	
	public NPC getNPC() {
		NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Item Shop"); 
		
		SkinTrait NPCSkin = npc.getOrAddTrait(SkinTrait.class);
		NPCSkin.setSkinName(this.skin);
		
		return npc;
	}
	
	public void spawnNPC() {
		this.getNPC().spawn(this.location);
	}
	
	@EventHandler
	public void click(net.citizensnpcs.api.event.NPCRightClickEvent event){
		if (event.getNPC() == this.getNPC()) {
			
		}
	}
}