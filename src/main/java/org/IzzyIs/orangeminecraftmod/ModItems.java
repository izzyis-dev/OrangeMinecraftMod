package org.IzzyIs.orangeminecraftmod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Creating an item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("orangemod", name));

        // Creating the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.ORANGE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.ORANGE_JUICE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.add(ModItems.ORANGE_SEEDS));
    }

    // Items
    // Orange
    public static final Item ORANGE = register("orange", Item::new, new Item.Settings().food(
            new FoodComponent.Builder()
                    .nutrition(3) // 3 halves of hunger will be restored
                    .saturationModifier(3) // 3 halves of saturation will be restored
                    .build()));
    // Orange Juice makes a food munching sound
    public static final ConsumableComponent ORANGE_JUICE_EFFECTS = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 2, 6), 1.0f)) // Heals 1 heart
            .build();
    public static final FoodComponent ORANGE_JUICE_FOOD = new FoodComponent.Builder().nutrition(7)
            .saturationModifier(7)
            .alwaysEdible()
            .build();
    public static final Item ORANGE_JUICE = register("orange_juice", Item::new, new Item.Settings().food(ORANGE_JUICE_FOOD, ORANGE_JUICE_EFFECTS));
    public static final Item ORANGE_SEEDS = register("orange_seeds", settings -> new BlockItem(ModBlocks.ORANGE_CROP_BLOCK, settings), new Item.Settings().useItemPrefixedTranslationKey());
}