package minecoders.progressive;

import minecoders.progressive.blocks.entities.ExampleBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockEntities {
    public static final BlockEntityType<ExampleBlockEntity> EXAMPLE = register("example", ExampleBlockEntity::new, Blocks.EXAMPLE);

    public static void initialize() {
        Progressive.LOGGER.info("Registering blocks entities...");
    }

    private static <T extends BlockEntity>
    BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T>  entityFactory, Block... blocks) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Progressive.id(name), FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }
}