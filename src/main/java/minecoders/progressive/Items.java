package minecoders.progressive;

import minecoders.progressive.util.helper.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

import java.util.function.Function;

public class Items {
    public static final Item PROGRESSIVE_ITEMGROUP_ICON = register("progressive_itemgroup_icon", Item::new, new Item.Settings());

    public static void initialize() {
        Progressive.LOGGER.debug("Registering items...");
    }

    public static <T extends Item>
    T register(String name, Function<Item.Settings, T> itemFactory, Item.Settings settings) {
        final RegistryKey<Item> key = RegistryHelper.getKeyOfItem(name);
        final T item = itemFactory.apply(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }
}
