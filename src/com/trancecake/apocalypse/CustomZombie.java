package com.trancecake.apocalypse;

import org.bukkit.entity.Zombie;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_13_R2.ChatMessage;
import net.minecraft.server.v1_13_R2.EntityChicken;
import net.minecraft.server.v1_13_R2.EntityPig;
import net.minecraft.server.v1_13_R2.EntityZombie;
import net.minecraft.server.v1_13_R2.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_13_R2.World;

public class CustomZombie extends EntityZombie {

	public CustomZombie(World world) {
		super(world);
		
		Zombie craftZombie = (Zombie) this.getBukkitEntity();
		
		this.setBaby(true);
		
		//craftZombie.setMaxHealth(50);
		
		this.setHealth(50);
		this.setCustomName(new ChatMessage(ChatColor.RED + "Zombie"));
		this.setCustomNameVisible(true);
		
		this.targetSelector.a(0, new PathfinderGoalNearestAttackableTarget<EntityPig>(this, EntityPig.class, true));
		this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntityChicken>(this, EntityChicken.class, true));

		this.getWorld().addEntity(this);
	}

}
