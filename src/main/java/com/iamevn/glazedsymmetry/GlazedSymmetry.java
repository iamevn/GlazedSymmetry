package com.iamevn.glazedsymmetry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;


@Mod(GlazedSymmetry.MOD_ID)
public class GlazedSymmetry {
    public static final String MOD_ID = "glazedsymmetry";
    public GlazedSymmetry() {
        Registration.register();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
