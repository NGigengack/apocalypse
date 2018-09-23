package com.minibouncy.apocalypsemod.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIZombieAttack;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityWalker extends EntityZombie {
	public EntityWalker(World worldIn) {
		super(worldIn);
	}
	
	protected void entityInit()
    {
		System.out.println("walker constructor");
        super.entityInit();
    }
	
	protected void initentityAI() {
	    this.tasks.addTask(0, new EntityAISwimming(this));
	    this.tasks.addTask(2, new EntityAIZombieAttack(this, 1.0D, false));
	    this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
	    this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
	    this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 24.0F));
	    this.tasks.addTask(8, new EntityAILookIdle(this));
	    
	    this.applyEntityAI();
	    
	}
	
	protected void applyEntityAttributes() {
        //super.applyEntityAttributes();
        //this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(45.0D);
        //this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        //this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        //this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
        //this.getAttributeMap().registerAttribute(SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(this.rand.nextDouble() * net.minecraftforge.common.ForgeModContainer.zombieSummonBaseChance);
        super.applyEntityAttributes();
	}
	
	public void onLivingUpdate() {
        if (!this.world.isDaytime() && !this.world.isRemote && !this.isChild()) {
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
            this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(90.0D);
        } else {
        	this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        	this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(45.0D);
        }

        super.onLivingUpdate();
    }
	
	public boolean shouldBurnInDay() {
		return false;
	}
	
	public EntityZombie createChild(EntityAgeable ageable) {
		return new EntityWalker(world);
	}

}
