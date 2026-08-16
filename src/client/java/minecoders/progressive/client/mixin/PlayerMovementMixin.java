package minecoders.progressive.client.mixin;

import minecoders.progressive.payload.IsPlayerMovingC2SPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class PlayerMovementMixin {
    @Unique private boolean progressive$previouslyMoving = false;
    @Shadow protected abstract boolean hasMovementInput();

    @Inject(
        at = @At("HEAD"),
        method = "tickMovement"
    )
    public void progressive$tickMovement$isMovingPacketSender(CallbackInfo callbackInfo) {
        boolean isMoving = hasMovementInput();

        if (isMoving == progressive$previouslyMoving)
            return;

        progressive$previouslyMoving = isMoving;
        ClientPlayNetworking.send(new IsPlayerMovingC2SPayload(isMoving));
    }
}
