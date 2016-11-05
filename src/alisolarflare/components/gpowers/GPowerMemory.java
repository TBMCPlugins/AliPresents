package alisolarflare.components.gpowers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

public class GPowerMemory{
	public Map<UUID, poweredPlayer> poweredPlayerList = new HashMap<UUID, poweredPlayer>();
	
	public void PowerUpPlayer(Player player, String colour){
		poweredPlayerList.put(player.getUniqueId(), new poweredPlayer(player.getUniqueId(), colour, true));
	}
	public void PowerUpPlayer(Player player){
		if(poweredPlayerList.containsKey(player.getUniqueId())){
			poweredPlayerList.get(player.getUniqueId()).isPowersActive = true;
		}else{
			player.sendMessage("You must instantiate your power settings using /GPower");
		}
	}
	
	public void PowerDownPlayer(Player player){
		if (poweredPlayerList.containsKey(player.getUniqueId())){
			poweredPlayerList.get(player.getUniqueId()).isPowersActive = false;
		}else{
			return;
		}
		
	}
	
	public class poweredPlayer{
		public UUID uuid;
		public String colour;
		public Boolean isPowersActive;

		public poweredPlayer(UUID uuid, String colour, Boolean activated){
			this.uuid = (uuid);
			this.colour = (colour);
			this.isPowersActive = (activated);
		}
		public String toString(){
			return "[UUID: "+ uuid.toString() + ", Colour: "+ colour+", IsActivated: "+isPowersActive + "]";
		}
	}
}

