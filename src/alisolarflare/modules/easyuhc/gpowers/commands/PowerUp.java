package alisolarflare.modules.easyuhc.gpowers.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.modules.PlayerCommand;
import alisolarflare.modules.easyuhc.gpowers.GPowerMemory;

public class PowerUp extends PlayerCommand {

	private GPowerMemory gPowerMemory;

	public PowerUp(GPowerMemory gPowerMemory) {
		this.gPowerMemory = gPowerMemory;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		if (!(sender instanceof Player))
			sender.sendMessage("You must be a player to use this command! Contact a dev/ali if you think this is wrong");
		
		Player player = (Player) sender;
		gPowerMemory.PowerUpPlayer(player);
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetCommandPath() {
		return "powerup";
	}
}
