package com.minibouncy.apocalypsemod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ConcreteBlock extends BlockBase 
{

	public ConcreteBlock(String name, Material material) 
	{
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(30.0F);
		setResistance(3000.0F);
		setHarvestLevel("pickaxe", 3);
	}

}
