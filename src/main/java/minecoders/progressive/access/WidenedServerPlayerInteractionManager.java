package minecoders.progressive.access;

import net.minecraft.util.math.BlockPos;

import java.util.Optional;

public interface WidenedServerPlayerInteractionManager {
    Optional<BlockPos> progressive$getMiningPosition();
}
