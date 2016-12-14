package buttondevteam.alipresents.components.alilinks.commands;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.alilinks.AliLinkAPI;

public class AliLink extends PlayerCommand{
	private JavaPlugin plugin;

	public AliLink(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean OnCommand(Player player, String alias, String[] inputFrequencies) {
		if(inputFrequencies.length < 1)
			return false;
		
		switch (inputFrequencies[0].toLowerCase()){
		case "press": 
			return AliLinkAPI.sendPressEvent(player, inputFrequencies, plugin);
		case "set":   
			return AliLinkAPI.createAliLink(player, inputFrequencies);
		default:
			return false;
		}
		
	}
	

	
	
}
