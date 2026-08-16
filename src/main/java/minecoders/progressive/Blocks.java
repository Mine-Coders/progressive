package minecoders.progressive;

import minecoders.progressive.blocks.ExampleBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Blocks {
    public static final Block EXAMPLE = register(
        "example",
        new ExampleBlock(AbstractBlock.Settings.create()
            .strength(4.0F)
            .requiresTool())
    );

    public static void initialize() {
        Progressive.LOGGER.info("Registering blocks...");
    }

    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, Progressive.id(name), block);
    }
}
