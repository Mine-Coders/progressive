package minecoders.progressive.mixin.addition;

import minecoders.progressive.access.MovingPlayer;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PlayerEntity.class)
public class PlayerMovementMixin implements MovingPlayer {
    @Unique public boolean progressive$isMoving = false;

    @Unique
    public boolean progressive$isMoving() {
        return progressive$isMoving;
    }

    @Unique
    public void progressive$setMoving(boolean isMoving) {
        progressive$isMoving = isMoving;
    }
}
