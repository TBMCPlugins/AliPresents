package alisolarflare.components.gpowers.enchant;

import java.util.Map;
import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import alisolarflare.components.gpowers.GPowerMemory;
import alisolarflare.components.gpowers.GPowerMemory.poweredPlayer;

public class EnchantingLoop extends BukkitRunnable implements Listener{
	private int powerLength = 300;
	private Server server;
	private Map<UUID, poweredPlayer> poweredPlayerList;

	
	public EnchantingLoop(JavaPlugin plugin, GPowerMemory gPowerMemory){
		this.server = plugin.getServer();
		this.poweredPlayerList = gPowerMemory.poweredPlayerList;
		this.runTaskTimer(plugin, 0, 190);
	}	
	
	//REPEATS EVERY 5 SECONDS
	@Override
	public void run() {
		//server.broadcastMessage("ping!");
		for (Player player : server.getOnlinePlayers()){
			if(poweredPlayerList.containsKey(player.getUniqueId()) && poweredPlayerList.get(player.getUniqueId()).isPowersActive){
				activatePower(player, poweredPlayerList.get(player.getUniqueId()).colour);
			}
		}
	}

	private void activatePower(Player player, String colour) {
		//GREY
		for (PotionEffect potionEffect : player.getActivePotionEffects()){
			player.removePotionEffect(potionEffect.getType());
		}
		if ((colour.startsWith("grey") || colour.startsWith("gra")) && (player.getWorld().getTime() > 12575 && player.getWorld().getTime() < 22925)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, powerLength, 0, true, false, Color.GRAY), true);
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, powerLength+100, 0, true, false, Color.GRAY), true);
		//RED
		}else if (colour.startsWith("r")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, powerLength, 0, true, false, Color.RED), true);
		//ORANGE
		}else if (colour.startsWith("o")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, powerLength, 0, true, false, Color.ORANGE), true);
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, powerLength, 0, true, false, Color.ORANGE), true);
		//YELLOW
		}else if (colour.startsWith("y") && player.getLocation().getBlock().getLightFromSky() == 15 && player.getLocation().getBlock().getLightFromBlocks() == 15){
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, powerLength, 0, true, false, Color.YELLOW), true);
		//GREEN
		}else if (colour.startsWith("g") && !colour.startsWith("gra") && !colour.startsWith("grey")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, powerLength, 1, true, false, Color.GREEN), true);
			player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, powerLength, 0, true, false, Color.GREEN), true);
		//BLUE
		}else if (colour.startsWith("b")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, powerLength, 1, true, false, Color.BLUE), true);
			player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, powerLength, 0, true, false, Color.BLUE), true);
		//PURPLE
		}else if (colour.startsWith("p")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, powerLength, 0, true, false, Color.PURPLE), true);
		//NULL
		}else{
		}
	}
	
}
