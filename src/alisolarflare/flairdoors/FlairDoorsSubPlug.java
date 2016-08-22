package alisolarflare.flairdoors;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.AliPresents;

public class FlairDoorsSubPlug{
	private AliPresents plugin;
	public FlairDoorsSubPlug(AliPresents plugin){
		this.plugin = plugin;
	}
	public void register(){
		registerCommands();
		registerEvents();
	}
	private void registerCommands() {
		plugin.getCommand("SetFlairDoorColour").setExecutor(new SetFlairDoorColour());
		
	}
	private void registerEvents() {
		// TODO Auto-generated method stub
		plugin.getServer().getPluginManager().registerEvents(new PortalLightListener(), plugin);

	}
}
