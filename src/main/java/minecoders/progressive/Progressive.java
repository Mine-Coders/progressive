package minecoders.progressive;

import eu.midnightdust.lib.config.MidnightConfig;
import minecoders.progressive.access.MovingPlayer;
import minecoders.progressive.api.ProgressiveIntegration;
import minecoders.progressive.integration.MidnightLibIntegration;
import minecoders.progressive.loot.functions.Example;
import minecoders.progressive.payload.IsPlayerMovingC2SPayload;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Progressive implements ModInitializer {
	public static final String MOD_ID = "progressive";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static MutableText translation(String key, String path) {
		return Text.translatable(key + '.' + MOD_ID + '.' + path);
	}

	public static MutableText translation(String key, String path, Object... args) {
		return Text.translatable(key + '.' + MOD_ID + '.' + path, args);
	}

	@Override
	public void onInitialize() {
		FabricLoader fabricLoader = FabricLoader.getInstance();
		Integrations.isMidnightLoaded = fabricLoader.isModLoaded("midnightlib");

		if (Integrations.isMidnightLoaded)
			MidnightConfig.init(Progressive.MOD_ID, MidnightLibIntegration.class);

		// Run Progressive integrations
		fabricLoader
			.getEntrypoints(MOD_ID, ProgressiveIntegration.class)
			.forEach(ProgressiveIntegration::onProgressiveInitialize);

		Components.initialize();
		Blocks.initialize();
		BlockEntities.initialize();
//		Items.initialize();
		ItemGroups.initialize();
		ScreenHandlers.initialize();
		LootFunctions.initialize();
		DamageSources.initialize();
		Sounds.initialize();

		PayloadTypeRegistry.playC2S().register(IsPlayerMovingC2SPayload.ID, IsPlayerMovingC2SPayload.CODEC);
		CommandRegistrationCallback.EVENT.register(Commands::register);

		ServerPlayNetworking.registerGlobalReceiver(IsPlayerMovingC2SPayload.ID, (payload, context) -> ((MovingPlayer) context.player()).progressive$setMoving(payload.isMoving()));

		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			if (!source.isBuiltin()
				|| !key.getValue().getPath().startsWith("entities/"))
				return;

			tableBuilder.apply(() -> new Example(List.of()));
		});
	}
}
