package minecoders.progressive.payload;

import minecoders.progressive.Progressive;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;

public record IsPlayerMovingC2SPayload(boolean isMoving) implements CustomPayload {
    public static final Id<IsPlayerMovingC2SPayload> ID = new Id<>(Progressive.id("is_player_moving"));
    public static final PacketCodec<RegistryByteBuf, IsPlayerMovingC2SPayload> CODEC = PacketCodec.tuple(PacketCodecs.BOOLEAN, IsPlayerMovingC2SPayload::isMoving, IsPlayerMovingC2SPayload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}