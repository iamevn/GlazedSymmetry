package com.iamevn.glazedsymmetry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    static void register() {}

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> reg_block = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(reg_block.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
        return reg_block;
    }
}
