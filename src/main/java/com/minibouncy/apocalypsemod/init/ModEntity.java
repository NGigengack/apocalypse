package com.minibouncy.apocalypsemod.init;

import com.minibouncy.apocalypsemod.Main;
import com.minibouncy.apocalypsemod.entity.EntityLootChicken;
import com.minibouncy.apocalypsemod.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntity 
{
	public static void registerEntities()
	{
		registerEntity("lootchicken", EntityLootChicken.class, Reference.ENTITY_LOOTCHICKEN, 50, 9288252,  9249852);
	}
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}

}
