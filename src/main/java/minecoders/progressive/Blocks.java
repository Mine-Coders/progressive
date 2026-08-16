package minecoders.progressive;

import minecoders.progressive.blocks.ExampleBlock;
import minecoders.progressive.util.helper.RegistryHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

import java.util.function.Function;

public class Blocks {
    public static final Block EXAMPLE = registerWithItem(
        "example",
        ExampleBlock::new,
        AbstractBlock.Settings.create()
            .strength(4.0F)
            .requiresTool()
    );

    public static void initialize() {
        Progressive.LOGGER.info("Registering blocks...");
    }

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        RegistryKey<Block> key = RegistryHelper.getKeyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static Block registerWithItem(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        RegistryKey<Item> key = RegistryHelper.getKeyOfItem(name);
        Block block = register(name, blockFactory, settings);
        Registry.register(Registries.ITEM, key, new BlockItem(block, new Item.Settings().registryKey(key).useBlockPrefixedTranslationKey()));
        return block;
    }
}
