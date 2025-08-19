package org.IzzyIs.orangeminecraftmod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import org.IzzyIs.orangeminecraftmod.ModBlocks;
import org.IzzyIs.orangeminecraftmod.Orangeminecraftmod;


public class OrangeminecraftmodClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.LEAVES_WITH_ORANGES, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.LEAVES_WITH_ORANGES, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.ORANGE_CROP_BLOCK, BlockRenderLayer.CUTOUT);
    }
}
