package alisolarflare.components.flairdoor;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.components.flairdoor.commands.FlairMe;
import alisolarflare.components.flairdoor.listeners.PortalListener;

public class FlairDoorModule extends Module {
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new FlairMe());

		registerListener(plugin, new PortalListener(plugin));
	}
}
