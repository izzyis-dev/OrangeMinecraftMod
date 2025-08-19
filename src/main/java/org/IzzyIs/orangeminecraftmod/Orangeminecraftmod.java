package org.IzzyIs.orangeminecraftmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class Orangeminecraftmod implements ModInitializer {
    // Current Mod ID, used to identify the mod that the user and for developer's sake.
    public static final String MOD_ID = "orangemod";

    @Override
    public void onInitialize() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LEAVES_WITH_ORANGES, 30, 60); // Burns as fast as any other leaves.
        ModBlocks.initialize();
        ModItems.initialize();
    }
}
