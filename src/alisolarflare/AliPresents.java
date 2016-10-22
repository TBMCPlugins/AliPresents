package alisolarflare;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;

import alisolarflare.flairdoors.FlairMe;
import alisolarflare.flairdoors.PortalListener;
import alisolarflare.flairdoors.SetFlairDoorColour;
import alisolarflare.gpowers.gPowerCommand;
import alisolarflare.gpowers.commands.PowerDown;
import alisolarflare.gpowers.commands.PowerUp;
import alisolarflare.gpowers.listeners.gPowerListener;

//import alisolarflare.links.AliLinkSubPlug;
import org.bukkit.plugin.java.JavaPlugin;
import alisolarflare.shulker.AliShulker;

public class AliPresents extends JavaPlugin{
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		
		logger.info(pdfFile.getName() + " has been started (V." + pdfFile.getVersion()+ ").");
		
		registerSubPlugins();
		registerCommands();
		registerEvents();
		
		logger.info(pdfFile.getName() + " has fully registered (V." + pdfFile.getVersion()+ ").");
		
		
	}
	private void registerEvents() {
		getServer().getPluginManager().registerEvents(new PortalListener(this), this);
		getServer().getPluginManager().registerEvents(new gPowerListener(this), this);
	}
	public void registerSubPlugins(){
		//AliLinkSubPlug alilinksubplugin = new AliLinkSubPlug(this);
		//alilinksubplugin.register();
	}
	public void registerCommands(){
		getCommand("powerup").setExecutor(new PowerUp());
		getCommand("powerdown").setExecutor(new PowerDown());
		getCommand("gpowercommand").setExecutor(new gPowerCommand());
		getCommand("flairme").setExecutor(new FlairMe());
		getCommand("alishulker").setExecutor(new AliShulker());
		getCommand("setflairdoorcolour").setExecutor(new SetFlairDoorColour());
		
	}
}
