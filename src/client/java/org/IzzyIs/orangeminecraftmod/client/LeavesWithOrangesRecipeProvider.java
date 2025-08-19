package org.IzzyIs.orangeminecraftmod.client;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.IzzyIs.orangeminecraftmod.ModBlocks;
import org.IzzyIs.orangeminecraftmod.ModItems;

import java.util.concurrent.CompletableFuture;

public class LeavesWithOrangesRecipeProvider extends FabricRecipeProvider {
    public LeavesWithOrangesRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                @SuppressWarnings("unused")
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                // Recipe for Leaves with Oranges
                createShapeless(RecipeCategory.FOOD, ModBlocks.LEAVES_WITH_ORANGES, 1)
                        .input(ModItems.ORANGE).input(ItemTags.LEAVES)
                        .criterion(hasItem(ModItems.ORANGE), conditionsFromItem(ModItems.ORANGE))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "LeavesWithOrangesRecipeProvider";
    }

}
