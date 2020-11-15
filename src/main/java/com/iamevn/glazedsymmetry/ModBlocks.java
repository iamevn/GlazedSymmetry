package com.iamevn.glazedsymmetry;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    final private static String[] COLORS = {"orange"};

    private static DyeColor getColor(String color) {
        switch (color) {
            case "orange":
                return DyeColor.ORANGE;
        }
        return DyeColor.WHITE;
    }
    private static AbstractBlock.Properties GlazedTerracottaProperties(String color) {
        return AbstractBlock.Properties.create(Material.ROCK, getColor(color)).setRequiresTool().hardnessAndResistance(1.4F);
    }

    static void register() {
        for (String color: COLORS) {
            register(color + "_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties(color)));
            register(color + "_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties(color)));
        }
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> reg_block = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(reg_block.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
        return reg_block;
    }
}
