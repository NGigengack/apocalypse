package com.trancecake.apocalypse;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import java.util.concurrent.TimeUnit;

public class PlayerListener implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
//		event.setJoinMessage(ChatColor.GOLD+"Run.");
		Player player = event.getPlayer();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		
			player.sendMessage(ChatColor.GOLD+"Run.");
			
			TimeUnit.SECONDS.sleep(3);
			
			for(int i = 0; i < 4; i++) {
				player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
			}
		} catch(InterruptedException e) {
			System.out.println("oops");
		}
	}
}
