package alisolarflare.easyuhc.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.DevCommand;
import alisolarflare.easyuhc.EasyUHCModule;

public class SetUHCLobby extends DevCommand{
	EasyUHCModule module;
	public SetUHCLobby(EasyUHCModule easyUHCModule) {
		this.module = easyUHCModule;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		module.lobbyLocation = ((Player) sender).getLocation();
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
