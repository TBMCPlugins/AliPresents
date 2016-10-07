package alisolarflare.flairdoors;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.material.Wool;

import alisolarflare.AliPresents;

public class PortalListener implements Listener{
	AbstractMap<String,Location> portalMap = new HashMap<String,Location>();
	public static List<String> playersToBeFlaired = new ArrayList<String>();
	public AliPresents plugin;
	
	//TODO: CREATE - LIST OF PORTALS (only x-z values)
	
	
	public PortalListener(AliPresents plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onPortalEnter(EntityPortalEvent event){
		//SANITATION - Player
		if(!(event.getEntity() instanceof Player)){
			return;
		}
		
		//INIT - Player
		Player player = (Player) event.getEntity();
		
		//SANITATION - PlayersToBeFlaired
		if(!(playersToBeFlaired.contains(player.getName()))){
			return;
		}
		player.sendMessage("MAY THE FLAIRING COMMENCE");
		player.sendMessage("Deactivating regular portal behaviour...");
		event.setCancelled(true);
		
		//INIT - x,y,z
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		
		//INIT - Blocks Under Portal
		Block blockTopper = player.getWorld().getBlockAt(x,y-1,z);
		Block blockMiddle = player.getWorld().getBlockAt(x,y-2,z);
		Block blockBottom = player.getWorld().getBlockAt(x,y-3,z);
		
		player.sendMessage("Blocks being inspected:");
		player.sendMessage(blockTopper.toString());
		player.sendMessage(blockMiddle.toString());
		player.sendMessage(blockBottom.toString());
		
		//RECOLOUR PLAYER
		if(blockTopper.getType() == Material.STONE){
			player.sendMessage("STONE DETECTED");
			recolourPlayer(player, DyeColor.GRAY);
			
		//TOP BLOCK IS WOOL?
		}else if(blockTopper.getType() == Material.WOOL){
			player.sendMessage("WOOL DETECTED T");
			Wool wool = (Wool) blockTopper;
			recolourPlayer(player, wool.getColor());
		
		//MIDDLE BLOCK IS WOOL?
		}else if(blockMiddle.getType() == Material.WOOL){

			player.sendMessage("WOOL DETECTED M");
			Wool wool = (Wool) blockMiddle;
			recolourPlayer(player, wool.getColor());
		
		//BOTTOM BLOCK IS WOOL?
		}else if (blockBottom.getType() == Material.WOOL){
			player.sendMessage("WOOL DETECTED B");
			Wool wool = (Wool) blockBottom;
			recolourPlayer(player, wool.getColor());
		}
		
	}
	public void recolourPlayer(Player player, DyeColor dyecolour){
		player.sendMessage("Recolouring Player as..." + dyecolour.toString());
		String name = player.getDisplayName();
		player.sendMessage("name:" + name);
		for(int i = 0; i < name.length(); i++){
			if (name.charAt(i) == '&'){
				//TODO: Remove all &* symbols
				name = name.substring(0, i) + name.substring(i + 1, name.length());
				
			}
		}
		player.sendMessage("Adjusted Name: " + name);
		
		if(dyecolour == DyeColor.GRAY){
			player.sendMessage("Adding GRAY");
			player.setDisplayName("&7" + name);
			
		}else if(dyecolour == DyeColor.RED){
			player.sendMessage("Adding RED");
			player.setDisplayName("&4" + name);
			
		}else if(dyecolour == DyeColor.ORANGE){
			player.sendMessage("Adding ORANGE");
			player.setDisplayName("&6" + name);
			
		}else if(dyecolour == DyeColor.YELLOW){
			player.sendMessage("Adding YELLOW");
			player.setDisplayName("&e" + name);
			
		}else if(dyecolour == DyeColor.GREEN){
			player.sendMessage("Adding GREEN");
			player.setDisplayName("&a" + name);
			
		}else if(dyecolour == DyeColor.BLUE){
			player.sendMessage("Adding BLUE");
			player.setDisplayName("&9" + name);
			
		}else if(dyecolour == DyeColor.PURPLE){
			player.sendMessage("Adding PURPLE");
			player.setDisplayName("&5" + name);
			
		}else{
			player.sendMessage("ERROR, PORTAL HAS INVALID UNDER-BLOCK");
			return;
		}
		player.sendMessage("Your name is now: " + player.getDisplayName() +"! Removing you from playersToBeFlaired...");
		playersToBeFlaired.remove(player.getName());
	}
}
