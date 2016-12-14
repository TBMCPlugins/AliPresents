package buttondevteam.alipresents.components.magic;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.magic.tricks.AliArrowListener;
import buttondevteam.alipresents.components.magic.tricks.BoomBowDeathListener;
import buttondevteam.alipresents.components.magic.tricks.BoomBowListener;
import buttondevteam.alipresents.components.magic.tricks.CannonBowListener;

public class MagicComponent extends Component{

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new AliArrowListener(plugin));
		registerListener(plugin, new BoomBowDeathListener());
		registerListener(plugin, new BoomBowListener(plugin));
		registerListener(plugin, new CannonBowListener(plugin));
	}
}
