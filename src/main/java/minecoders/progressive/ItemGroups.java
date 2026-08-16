package minecoders.progressive;

import minecoders.progressive.util.helper.TranslationHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class ItemGroups {
    public static final ItemGroup PROGRESSIVE = register(
        "progressive", Items.PROGRESSIVE_ITEMGROUP_ICON,
        Blocks.EXAMPLE.asItem()
    );

    @SafeVarargs
    public static <T extends Item>
    ItemGroup register(String name, T icon, T... items) {
        Identifier identifier = Progressive.id(name);
        ItemGroup itemGroup = FabricItemGroup.builder()
            .icon(() -> new ItemStack(icon))
            .displayName(TranslationHelper.itemGroup(name))
            .build();

        Registry.register(Registries.ITEM_GROUP, identifier, itemGroup);

        ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(Registries.ITEM_GROUP.getKey(), identifier)).register(groupEntries -> {
            for (T item : items)
                groupEntries.add(item);
        });

        return itemGroup;
    }

    public static void initialize() {
        Progressive.LOGGER.debug("Initialized Item Groups");
    }
}
