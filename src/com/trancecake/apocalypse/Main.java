package com.trancecake.apocalypse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getLogger().info(ChatColor.RED+"A sharp scent comes in with he wind... It feels like something very bad just happened...");
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
	}
	
	@Override
	public void onDisable() {
		this.getLogger().info(ChatColor.RED+"The air clears, suddenly everyone feels a lot better!");
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("spawnzombies")) {
			Player player = Bukkit.getPlayer(sender.getName());
			
			player.sendMessage(ChatColor.GOLD+"Run.");
			
			for(int i = 0; i < 4; i++) {
				player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
			}
		}
		
		return false;
	}
	
}
