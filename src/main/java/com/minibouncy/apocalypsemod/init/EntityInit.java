package com.minibouncy.apocalypsemod.init;

import java.util.ArrayList;
import java.util.List;

import com.minibouncy.apocalypsemod.Main;
import com.minibouncy.apocalypsemod.entity.EntityLootChicken;
import com.minibouncy.apocalypsemod.entity.EntityWalker;
import com.minibouncy.apocalypsemod.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntities() {
		System.out.println("registering walker");
		registerEntity("walker", EntityWalker.class, Reference.ENTITY_WALKER, 50, 7820858, 11061950);
		registerEntity("lootchicken", EntityLootChicken.class, Reference.ENTITY_LOOTCHICKEN, 50, 9288252,  9249852);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
//		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, name), entity, name, id, Main.instance, range, 1, true, color1, color2);
		//EntityRegistry.registerEgg(new ResourceLocation(Reference.MOD_ID + ":" + name), color1, color2);
		List<Biome> spawnBiomes = new ArrayList<Biome>();
		spawnBiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.PLAINS));
		spawnBiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST));
		spawnBiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.HILLS));
		spawnBiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.SWAMP));

		spawnBiomes.removeAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER));
		spawnBiomes.removeAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.END));
		EntityRegistry.addSpawn(EntityWalker.class, 20, 10, 150, EnumCreatureType.MONSTER, spawnBiomes.toArray(new Biome[spawnBiomes.size()]));
		//new ResourceLocation()
	}
}
