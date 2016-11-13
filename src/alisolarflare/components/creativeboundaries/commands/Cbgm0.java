package alisolarflare.components.creativeboundaries.commands;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.creativeboundaries.CreativeBoundariesComponent;

public class Cbgm0 extends PlayerCommand{
	
	private List<Player> cbCreatives;

	public Cbgm0(CreativeBoundariesComponent component) {
		this.cbCreatives = component.cbCreatives;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		player.setGameMode(GameMode.SURVIVAL);
		cbCreatives.remove(player);
		return true;
	}
	public String[] GetHelpText(String alias){
		return new String[]{
			"Creative Boundaries Usage: /cbgm0"
		};
	}
}
