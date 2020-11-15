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
    final private static String[] COLORS = {
            "white", "light_gray", "red", "purple",
            "pink", "orange", "magenta", "lime",
            "light_blue", "green", "gray", "cyan",
            "brown", "blue", "yellow", "black"
    };

    private static DyeColor getColor(String color) {
        switch (color) {
            case "white":
                return DyeColor.WHITE;
            case "light_gray":
                return DyeColor.LIGHT_GRAY;
            case "red":
                return DyeColor.RED;
            case "purple":
                return DyeColor.PURPLE;
            case "pink":
                return DyeColor.PINK;
            case "orange":
                return DyeColor.ORANGE;
            case "magenta":
                return DyeColor.MAGENTA;
            case "lime":
                return DyeColor.LIME;
            case "light_blue":
                return DyeColor.LIGHT_BLUE;
            case "green":
                return DyeColor.GREEN;
            case "gray":
                return DyeColor.GRAY;
            case "cyan":
                return DyeColor.CYAN;
            case "brown":
                return DyeColor.BROWN;
            case "blue":
                return DyeColor.BLUE;
            case "yellow":
                return DyeColor.YELLOW;
            case "black":
                return DyeColor.BLACK;
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
        Registration.ITEMS.register(name, () -> new BlockItem(reg_block.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
        return reg_block;
    }
}
