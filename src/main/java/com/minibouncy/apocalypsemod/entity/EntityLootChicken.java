package com.minibouncy.apocalypsemod.entity;

import com.minibouncy.apocalypsemod.util.handlers.LootTableHandler;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityLootChicken extends EntityChicken {

	public EntityLootChicken(World worldIn) {
		super(worldIn);
	}
	
	
	@Override
	protected ResourceLocation getLootTable()
    {
        return LootTableHandler.LOOTCHICKEN;
    }
}
