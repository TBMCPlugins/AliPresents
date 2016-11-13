package alisolarflare.components.creativeboundaries.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.components.ModCommand;
import alisolarflare.components.creativeboundaries.CreativeBoundariesComponent;

public class SetDickmode extends ModCommand{
	boolean dickMode;

	public SetDickmode(CreativeBoundariesComponent component){
		this.dickMode = component.dickmode;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {		
		if(args.length < 1){
			sender.sendMessage("You must use True, False, 1, or 0 as arguments!");
			return false;
		}
		String firstArgument = args[0];
		if(firstArgument.startsWith("t") || firstArgument.equals("1")){
			sender.sendMessage("Dickmode has been turned on!");
			dickMode = true;
			return true;
		}
		if(firstArgument.startsWith("f") || firstArgument.equals("0")){
			sender.sendMessage("Dickmode has been turned off!");
			dickMode = false;
			return true;
		}
		return false;
	}
}
