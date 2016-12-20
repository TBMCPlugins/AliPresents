package buttondevteam.alipresents.components.magic.tricks;

import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;

public class CannonBowSettings extends ModCommand {

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		switch(args[0].toLowerCase()){
		case "speedmultiplier":
			double speedMultiplier = NumberUtils.toDouble(args[1], CannonBowListener.SpeedMultiplier);
			CannonBowListener.SpeedMultiplier = speedMultiplier;
			this.getPlugin().getConfig().set("magic.cannonbow.speedmultiplier", speedMultiplier);
			this.getPlugin().saveConfig();
			break;
		case "minforce":
			double minforce = NumberUtils.toDouble(args[1], CannonBowListener.minforce);
			CannonBowListener.minforce = minforce;
			this.getPlugin().getConfig().set("magic.cannonbow.minforce", minforce);
			this.getPlugin().saveConfig();
			break;
		default:
			player.sendMessage("That isn't a valid setting!");
			player.sendMessage("Valid Settings are: ");
			return false;
		}
		return true;
	}
	
	@Override
	public String GetCommandPath(){
		return "magic cannonbow";
	}
	
}
