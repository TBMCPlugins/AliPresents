package alisolarflare.components.creativeboundaries.listeners;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.palmergames.bukkit.towny.event.PlayerChangePlotEvent;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyUniverse;

import alisolarflare.components.creativeboundaries.CreativeBoundariesComponent;

public class PlotChangeListener implements Listener{
	private boolean dickmode;
	private List<Player> cbCreatives;
	
	public PlotChangeListener(CreativeBoundariesComponent module){
		this.dickmode = module.dickmode;
		this.cbCreatives = module.cbCreatives;
	}
	@EventHandler
	public void onPlayerPlotChange(PlayerChangePlotEvent plotEvent){
		Player player = plotEvent.getPlayer();
		if (dickmode == false){
			return;
		}
		if (plotEvent.getPlayer().getGameMode() != GameMode.CREATIVE){
			return;
		}
		if (!(cbCreatives.contains(plotEvent.getPlayer()))){
			return;
		}
		TownBlock tb = TownyUniverse.getTownBlock(player.getLocation());
		if (tb == null) {
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage("You have left your town boundaries!");
			cbCreatives.remove(player);
			return;
		}
		Town town;
		try {
			town = tb.getTown();
		} catch (NotRegisteredException e) {
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage("You have left your town boundaries!!");
			cbCreatives.remove(player);
			return;
		}
		
		if (town == null) {
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage("You have left your town boundaries!!!");
			cbCreatives.remove(player);
			return;
		}
		boolean townHasRes = false;
		for(Resident res : town.getResidents()){
			if (res.getName().toString().equals(player.getName().toString())){
				townHasRes = true;			
			}
		}
		if (!townHasRes){
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage("You have left your town boundaries!!!!");
			cbCreatives.remove(player);
		}
	}
}
