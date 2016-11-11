package alisolarflare.easyuhc.gpowers.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.easyuhc.gpowers.GPowerMemory;
import buttondevteam.lib.chat.TBMCCommandBase;

public class GPower extends TBMCCommandBase {

	private GPowerMemory gPowerMemory;

	public GPower(GPowerMemory gPowerMemory) {
		this.gPowerMemory = gPowerMemory;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		sender.sendMessage("G power activate!");
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command! Talk to a dev/ali if you think this is wrong");
		}
		Player player = (Player) sender;
		if (args.length < 2) {
			player.sendMessage("Proper Usage to test G-Powers:");
			player.sendMessage("/gpowertest [colour=red,orange,yellow,green,blue,purple] [active=true/false]");
			return false;
		}
		String colour;
		if (args[0].startsWith("r") || args[0].startsWith("o") || args[0].startsWith("y") || args[0].startsWith("g")
				|| args[0].startsWith("b") || args[0].startsWith("p")) {
			colour = args[0];
		} else {
			player.sendMessage("error: colour. Proper Usage to configure G-Powers:");
			player.sendMessage("/gpowertest [colour=red,orange,yellow,green,blue,purple,grey] [active=true/false]");
			return false;
		}
		boolean isActive;
		if (args[1].startsWith("t")) {
			isActive = true;
		} else if (args[1].startsWith("f")) {
			isActive = false;
		} else {
			player.sendMessage("error: active. Proper Usage to configure G-Powers:");
			player.sendMessage("/gpowertest [colour=red,orange,yellow,green,blue,purple] [active=true/false]");
			return false;
		}
		player.sendMessage("Terms Vaild!");
		player.sendMessage("Saving Data: "+ player.getName() + "|" + colour + "|" + isActive);
		gPowerMemory.configurePlayer(player, colour, isActive);
		
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return new String[] { "" };
	}

	@Override
	public String GetCommandPath() {
		return "gpower";
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
