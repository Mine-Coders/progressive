package minecoders.progressive.server;

import minecoders.progressive.SharedInteractions;
import minecoders.progressive.access.WidenedServerPlayerInteractionManager;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;

import java.util.Optional;

public class ProgressiveServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        SharedInteractions.initializeMiningPositionGetter(player -> {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
            MinecraftServer server = serverPlayer.getServer();

            if (server == null) // SATISFY: Null comparison not needed since it is guaranteed that this method is running on the server
                return Optional.empty();

            ServerPlayerInteractionManager interactionManager = server.getPlayerInteractionManager(serverPlayer);

            if (interactionManager == null)
                return Optional.empty();

            return ((WidenedServerPlayerInteractionManager) interactionManager).progressive$getMiningPosition();
        });
    }
}