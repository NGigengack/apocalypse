package com.minibouncy.apocalypsemod.init;

import com.minibouncy.apocalypsemod.Main;
import com.minibouncy.apocalypsemod.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntities() {
		registerEntity("walker", EntityWalker.class, Reference.ENTITY_WALKER, 50, 7820858, 000000);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance ,range, 1, true, color1, color2);
	}
}
