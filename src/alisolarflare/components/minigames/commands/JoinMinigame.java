package alisolarflare.components.minigames.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.minigames.MinigameModule;

public class JoinMinigame extends PlayerCommand {
	private MinigameModule module;

	public JoinMinigame(MinigameModule module) {
		this.module = module;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {		
		String name = sender.getName();
		if (module.fighters.contains(name)) {
			sender.sendMessage("You are already in the minigame!");
			return true;
		}

		module.fighters.add(name);

		if (module.fighters.contains(name)) {
			sender.sendMessage("You have joined the minigame!");
		}
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /JoinMinigame to join a current button minigame!"
		};
	}
}
