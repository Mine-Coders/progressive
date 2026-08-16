package minecoders.progressive;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Items {
//    public static final BlockItem EXAMPLE = registerBlock("example", Blocks.EXAMPLE);
    public static final Item PROGRESSIVE_ITEMGROUP_ICON = register("progressive_itemgroup_icon", new Item(new Item.Settings()));

    public static void initialize() {
        Progressive.LOGGER.debug("Registering items...");
    }

    public static BlockItem registerBlock(String name, Block block) {
        final BlockItem blockItem = new BlockItem(block, new Item.Settings());
        return register(name, blockItem);
    }

    public static <GenericItem extends Item>
    GenericItem register(String name, GenericItem item) {
        Registry.register(Registries.ITEM, Progressive.id(name), item);
        return item;
    }
}
