package com.minibouncy.apocalypsemod.init;

import java.util.ArrayList;
import java.util.List;

import com.minibouncy.apocalypsemod.blocks.BlockBase;
import com.minibouncy.apocalypsemod.blocks.ConcreteBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block CONCRETE_BLOCK = new ConcreteBlock("concrete_block", Material.IRON);
}
