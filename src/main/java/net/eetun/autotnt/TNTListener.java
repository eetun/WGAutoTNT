package net.eetun.autotnt;

import org.bukkit.Material;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class TNTListener implements Listener {

	@SuppressWarnings("unused")
	private WGAutoTNTPlugin plugin;
	private WorldGuardPlugin wgPlugin;	
	
	public TNTListener(WGAutoTNTPlugin plugin, WorldGuardPlugin wgPlugin) {
		
		this.plugin = plugin;
		this.wgPlugin = wgPlugin;
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){  
		
		if(wgPlugin.getGlobalRegionManager().allows(WGAutoTNTPlugin.TNT_FLAG, e.getBlock().getLocation())) {
			
			if(e.getBlock().getType() == Material.TNT) {
				e.getBlock().setType(Material.AIR);
				e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0.5, 0.25, 0.5), TNTPrimed.class);
			}
		
		}		
		
	}
	
	
}
