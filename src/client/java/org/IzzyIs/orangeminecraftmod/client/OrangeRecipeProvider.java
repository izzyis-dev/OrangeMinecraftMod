package org.IzzyIs.orangeminecraftmod.client;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import org.IzzyIs.orangeminecraftmod.ModItems;

import java.util.concurrent.CompletableFuture;

public class OrangeRecipeProvider extends FabricRecipeProvider {
    public OrangeRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                @SuppressWarnings("unused")
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                // Recipe for Oranges, this is the only way to obtain orange naturally without crops
                createShapeless(RecipeCategory.FOOD, ModItems.ORANGE)
                        .input(Items.ORANGE_DYE).input(Items.APPLE)
                        .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                        .offerTo(exporter);

            }
        };
    }

    @Override
    public String getName() {
        return "OrangeRecipeProvider";
    }


}
