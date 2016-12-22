package buttondevteam.alipresents.components.hotfix.hotfixes;

import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CreativeKillLoop extends BukkitRunnable implements Listener {
	private Server server;

	public CreativeKillLoop(JavaPlugin plugin){
		this.server = plugin.getServer();
		this.runTaskTimer(plugin, 40, 40);
	}

	@Override
	public void run() {
		for (Player player : server.getOnlinePlayers()){
			if(player.getGameMode() != GameMode.SURVIVAL && player.getWorld().getName() == "World" && player.isOp() == false){
				player.sendMessage("[Hotfix] Every Gamemode other than survival is disabled in the new world!");
				player.setGameMode(GameMode.SURVIVAL);
			}
		}
	}

}
