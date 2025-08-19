package org.IzzyIs.orangeminecraftmod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class OrangeCropBlock extends CropBlock {
    public OrangeCropBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.ORANGE_SEEDS;
    }
}
