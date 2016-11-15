package alisolarflare.components.flairdoor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;
import alisolarflare.components.flairdoor.commands.FlairMe;
import alisolarflare.components.flairdoor.commands.SetProximityLocation;
import alisolarflare.components.flairdoor.listeners.PlayerProximityTaskLauncher;
import alisolarflare.components.flairdoor.listeners.PortalListener;

public class FlairDoorComponent extends Component {
	public List<Player> playersToBeFlaired = new ArrayList<Player>();
	public Location startLocation = null;
	public Location endLocation = null;
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new FlairMe(this));
		registerCommand(plugin, new SetProximityLocation(this));
		registerListener(plugin, new PortalListener(plugin, this));
		registerListener(plugin, new PlayerProximityTaskLauncher(plugin, this));
	}
}
