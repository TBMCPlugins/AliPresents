package buttondevteam.alipresents.components.gpower.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.gpower.api.GPowerAPI;

public class GPower extends PlayerCommand {
	@Override
	public String GetCommandPath() {
		return "gpower";
	}
	@Override
	public boolean OnCommand(Player player, String label, String[] args) {
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
			return false;
		}
		boolean isActive;
		if (args[1].startsWith("t")) {
			isActive = true;
		} else if (args[1].startsWith("f")) {
			isActive = false;
		} else {
			player.sendMessage("error: active. Proper Usage to configure G-Powers:");
			return false;
		}
		player.sendMessage("Terms Vaild!");
		player.sendMessage("Saving Data: "+ player.getName() + "|" + colour + "|" + isActive);
		GPowerAPI.addPlayer(player, colour, isActive);
		
		return true;
	}
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: /gpowertest [colour=red,orange,yellow,green,blue,purple,grey] [active=true/false]"
		};
	}
}
