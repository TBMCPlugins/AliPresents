package alisolarflare;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.lib.TBMCCoreAPI;
import buttondevteam.lib.chat.TBMCChatAPI;
import buttondevteam.lib.chat.TBMCCommandBase;

/**
 * A Module class allows the compacting of projects into one single package. 
 * 
 * Each feature can have its commands and listeners coded into the Module class,
 * as well as any other pointers to memory units, or other classes in the package. 
 * 
 * This package can then be moved from eclipse project to eclipse project smoothly, 
 * as long as the destination project has the Module abstract class, and as long as all dependencies are either
 * contained in the moved package, or moved along with it.
 * @author Alisolarflare
 *
 */
public abstract class Module{
	/**
	 * Registers the module, when called by the JavaPlugin class. Call
	 * registerCommand() and registerListener() within this method.
	 * 
	 * @param plugin	Plugin class called to register commands and listeners
	 */
	public abstract void register(JavaPlugin plugin);
	/**
	 * Registers a TBMCCommand to the plugin
	 * @param plugin          Main plugin responsible for stuff
	 * @param label           Name of the command in plugin.yml
	 * @param commandExecutor Custom coded CommandExecutor class 
	 */
	protected void registerCommand(JavaPlugin plugin, TBMCCommandBase commandBase){
		TBMCChatAPI.AddCommand(plugin, commandBase);
	}
	/**
	 * Registers a Listener to this plugin
	 * @param plugin          Main plugin responsible for stuff
	 * @param label           Name of the command in plugin.yml
	 * @param commandExecutor Custom coded CommandExecutor class 
	 */
	protected Listener registerListener(JavaPlugin plugin, Listener listener){
		TBMCCoreAPI.RegisterEventsForExceptions(listener, plugin);
		return listener;
	}
	
}
