package com.minibouncy.apocalypsemod.util.handlers;

import com.minibouncy.apocalypsemod.init.EntityInit;
import com.minibouncy.apocalypsemod.init.ModBlocks;
import com.minibouncy.apocalypsemod.init.ModEntity;
import com.minibouncy.apocalypsemod.init.ModItems;
import com.minibouncy.apocalypsemod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS) 
		{
			if(item instanceof IHasModel) 
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block: ModBlocks.BLOCKS) 
		{
			if(block instanceof IHasModel) 
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void preInitRegistries() 
	{
		ModEntity.registerEntities();
		EntityInit.registerEntities();
		EntityInit.unregisterEntities();
	}

	public static void InitRegistries() {
		// TODO Auto-generated method stub
		
	}

	public static void postInitRegistries() {
		// TODO Auto-generated method stub
		
	}
}
