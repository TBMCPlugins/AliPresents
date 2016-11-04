package alisolarflare.minigames.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.minigames.MinigameModule;
import buttondevteam.lib.chat.TBMCCommandBase;

public class JoinMinigame extends TBMCCommandBase {
	private MinigameModule minigame;

	public JoinMinigame(MinigameModule minigame) {
		this.minigame = minigame;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		String name = sender.getName();
		if (minigame.fighters.contains(name)) {
			sender.sendMessage("You are already in the minigame!");
			return false;
		}

		minigame.fighters.add(name);

		if (minigame.fighters.contains(name)) {
			sender.sendMessage("You have joined the minigame!");
		}
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean GetPlayerOnly() {
		return true;
	}

	@Override
	public boolean GetModOnly() {
		return false;
	}

}
