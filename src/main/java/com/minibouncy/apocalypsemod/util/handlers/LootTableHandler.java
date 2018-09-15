package com.minibouncy.apocalypsemod.util.handlers;

import com.minibouncy.apocalypsemod.util.Reference;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LootTableHandler 
{
	public static final ResourceLocation LOOTCHICKEN = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "lootchicken"));
	
	@SubscribeEvent
	public void onMobDrops(LivingDropsEvent event)
	{
		if (event.getEntity() instanceof EntityChicken)
		{
			event.getDrops().clear();
			
			ItemStack stackFeathers = new ItemStack(Items.FEATHER, getAmount(6, 40));
			ItemStack stackEggs = new ItemStack(Items.EGG, getAmount(1, 10));
			event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, 
		              event.getEntity().posY, event.getEntity().posZ, stackFeathers));
			event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, 
		              event.getEntity().posY, event.getEntity().posZ, stackEggs));
		}
	}

	private int getAmount(int min, int max) {
	    return (int) ((Math.random()*((max-min)+1))+min);
	}

}
