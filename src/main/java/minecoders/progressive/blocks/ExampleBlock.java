package minecoders.progressive.blocks;

import com.mojang.serialization.MapCodec;
import minecoders.progressive.BlockEntities;
import minecoders.progressive.blocks.entities.ExampleBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ExampleBlock extends BlockWithEntity {
    @SuppressWarnings("unused")
    public ExampleBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(ExampleBlock::new);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ExampleBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient())
            return null;

        return validateTicker(type, BlockEntities.EXAMPLE, ExampleBlockEntity::tick);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient())
            return ActionResult.SUCCESS;

        NamedScreenHandlerFactory factory = state.createScreenHandlerFactory(world, pos);
        player.openHandledScreen(factory);
        return ActionResult.SUCCESS;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.isOf(newState.getBlock())) {
            super.onStateReplaced(state, world, pos, newState, moved);
            return;
        }

        if (!(world.getBlockEntity(pos) instanceof ExampleBlockEntity exampleBlockEntity) || !(world instanceof ServerWorld)) {
            super.onStateReplaced(state, world, pos, newState, moved);
            return;
        }

        ItemScatterer.spawn(world, pos, exampleBlockEntity);
        super.onStateReplaced(state, world, pos, newState, moved);
    }
}
