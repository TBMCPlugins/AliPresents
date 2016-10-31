package alisolarflare.modules.components.gpowers.listeners;

import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import alisolarflare.modules.components.gpowers.gPowerMemory;

public class gPowerApplyingTask extends BukkitRunnable{
	
	private JavaPlugin plugin;

	public gPowerApplyingTask(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
	//REPEATS EVERY 5 SECONDS
	@Override
	public void run() {
		for (Player player : plugin.getServer().getOnlinePlayers()){
			if(gPowerMemory.PlayerMap.containsKey(player.getUniqueId())){
				activatePower(player, gPowerMemory.PlayerMap.get(player.getUniqueId()).colour);
			}
		}
	}

	private void activatePower(Player player, String colour) {
		if ((colour.startsWith("grey") || colour.startsWith("gra")) && (player.getWorld().getTime() > 12575 && player.getWorld().getTime() < 22925)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 0, true, false, Color.GRAY));
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 300, 0, true, false, Color.GRAY));
		}else if (colour.startsWith("r")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0, true, false, Color.RED));
		}else if (colour.startsWith("o")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 0, true, false, Color.ORANGE));
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 0, true, false, Color.ORANGE));
		}else if (colour.startsWith("y") && player.getLocation().getBlock().getLightFromSky() == 15 && player.getLocation().getBlock().getLightFromBlocks() == 15){
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 0, true, false, Color.YELLOW));
		}else if (colour.startsWith("g") && !colour.startsWith("gra") && !colour.startsWith("grey")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 200, 1, true, false, Color.GREEN));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 0, true, false, Color.GREEN));
		}else if (colour.startsWith("b")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1, true, false, Color.BLUE));
			player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 200, 0, true, false, Color.BLUE));
		}else if (colour.startsWith("p")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 200, 0, true, false, Color.PURPLE));
		}else{
		}
	}
	
}
