package alisolarflare;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.lib.TBMCCoreAPI;
import buttondevteam.lib.chat.TBMCChatAPI;
import buttondevteam.lib.chat.TBMCCommandBase;

/**
 * A Module class is a helper class that allows the compacting of projects into one single package. 
 * Each feature, whether game, arrow trail listener, or command tool, can have its command and listener
 * registration coded into the Module class, as well as any other pointers to memory units, or other
 * classes in the package. 
 * 
 * This package can then be moved from eclipse project to eclipse project smoothly, 
 * as long as the destination project has the Module abstract class, and as long as all dependencies are either
 * contained in the moved package, or moved along with it.
 * @author Alisolarflare
 *
 */
public abstract class Module{
	/**
	 * Registers the project, when called by the Main JavaPlugin class that handles
	 * the main plugin. 
	 * 
	 * To register a command, call plugin.getCommand(//label).setExecutor(//commandExecutor); where
	 * label is a string containing the name of the command in plugin.yml, and where commandExecutor
	 * is a class implementing command executor
	 * 
	 * To register a listener,
	 * @param plugin	Plugin class called to register commands and listeners
	 */
	public abstract void register(JavaPlugin plugin);
	/**
	 * Lazy route to type plugin.getCommand("label").setExecutor
	 * @param plugin          Main plugin responsible for stuff
	 * @param label           Name of the command in plugin.yml
	 * @param commandExecutor Custom coded CommandExecutor class 
	 */
	protected void registerCommand(JavaPlugin plugin, TBMCCommandBase commandBase){
		TBMCChatAPI.AddCommand(plugin, commandBase);
	}
	protected Listener registerListener(JavaPlugin plugin, Listener listener){
		TBMCCoreAPI.RegisterEventsForExceptions(listener, plugin);
		return listener;
	}
}
