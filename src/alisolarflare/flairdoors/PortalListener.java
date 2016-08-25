package alisolarflare.flairdoors;

import java.util.AbstractMap;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCreatePortalEvent;

import alisolarflare.AliPresents;

public class PortalListener implements Listener{
	AbstractMap<String,Location> portalMap = new HashMap<String,Location>();
	private AliPresents plugin;
	
	//TODO: CREATE - LIST OF PORTALS (only x-z values)
	
	
	public PortalListener(AliPresents plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPortalLight(EntityCreatePortalEvent event){
		plugin.getServer().broadcastMessage("PORTAL LIT WHOOP WHOOP");
		plugin.getServer().broadcastMessage(event.getEntity().getName());
		//SANITATION - entity > player
		if(!(event.getEntity() instanceof Player)){return;}
		Player player = (Player) event.getEntity();
		event.getEntity().getServer().broadcastMessage(player.getName());
		
		//SANITIATION - player > alisolarflare
		if(!(player.getName() == "alisolarflare")){return;}
		event.getEntity().getServer().broadcastMessage(SetFlairDoorColour.FlairDoorColorMode);
		//SANITATION - FlairDoorColourMode
		if (SetFlairDoorColour.FlairDoorColorMode == "null"){
			player.sendMessage("Your Colour mode is set to Null, use /SetFlairDoorColour [Color] to specify a colour for this portal");
			return;
		}

		//INIT - colourMode, portalLocation
		String colourMode = SetFlairDoorColour.FlairDoorColorMode;
		Location portalLocation = event.getBlocks().get(0).getBlock().getLocation();
		event.getEntity().getServer().broadcastMessage(portalLocation.toString()); 
		//SAVE - Portal
		if(SetFlairDoorColour.COLOURMODES.contains(colourMode)){
			for (BlockState blockstate : event.getBlocks()){
				player.sendMessage(blockstate.getBlock().getLocation().toString());
			}
			portalMap.put(colourMode, portalLocation);
		}
	}
	/*
	@EventHandler
	public void onPortalEnter(EntityPortalEvent event){
		//TODO: IF PLAYER LOCATION IS INSIDE A COLOUR PORTAL
		//TODO: IF PLAYER NOT FLAIRED
		//TODO: IF PLAYERSTATE IS TRUE
		//TODO: CHANGE CUSTOM DISPLAY NAME
		//TODO: TELEPORT TO SPAWN
		//TODO: MARK PLAYER AS COLOURED
		
	}
	*/
}
