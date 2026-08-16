package minecoders.progressive;

//import minecoders.progressive.blocks.entities.ExampleBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.jetbrains.annotations.NotNull;

public class BlockEntities {
//    public static final BlockEntityType<ExampleBlockEntity> EXAMPLE = register("example", ExampleBlockEntity::new, Blocks.EXAMPLE);

    public static void initialize() {
        Progressive.LOGGER.info("Registering blocks entities...");
    }

//    private static <T extends BlockEntity>
//    BlockEntityType<T> register(String name, BlockEntityType.BlockEntityFactory<? extends @NotNull T> entityFactory, Block... blocks) {
//        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Progressive.id(name), BlockEntityType.Builder.<T>create(entityFactory, blocks).build());
//    }
}