package alisolarflare.modules.easyuhc.gpowers.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.modules.ModCommand;
import alisolarflare.modules.easyuhc.gpowers.GPowerMemory;
import alisolarflare.modules.easyuhc.gpowers.GPowerMemory.poweredPlayer;

public class PowerAll extends ModCommand{
	private GPowerMemory gPowerMemory;

	public PowerAll(GPowerMemory gPowerMemory) {
		this.gPowerMemory = gPowerMemory;
	}
	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		for (poweredPlayer poweredPlayer : gPowerMemory.poweredPlayerList.values()){
			poweredPlayer.isPowersActive = true;
		}
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}
}
