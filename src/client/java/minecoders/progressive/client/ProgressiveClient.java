package minecoders.progressive.client;

import minecoders.progressive.ScreenHandlers;
import minecoders.progressive.SharedInteractions;
import minecoders.progressive.api.client.ProgressiveClientIntegration;
import minecoders.progressive.client.access.WidenedClientPlayerInteractionManager;
import minecoders.progressive.client.screens.block.ExampleScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.Optional;

public class ProgressiveClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		SharedInteractions.initializeMiningPositionGetter(player -> {
			ClientPlayerInteractionManager interactionManager = MinecraftClient.getInstance().interactionManager;

			if (interactionManager == null)
				return Optional.empty();

			return ((WidenedClientPlayerInteractionManager) interactionManager).progressive$getMiningPosition();
		});

		HandledScreens.register(
			ScreenHandlers.EXAMPLE,
			ExampleScreen::new
		);

		FabricLoader fabricLoader = FabricLoader.getInstance();

		fabricLoader
			.getEntrypoints("progressive-client", ProgressiveClientIntegration.class)
			.forEach(ProgressiveClientIntegration::onProgressiveInitialize);

		KeyBinding debug1 = KeyBindingHelper.registerKeyBinding(
			new KeyBinding(
				"key.progressive.debug1",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_U,
				"key.category.progressive"
			)
		);

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			do {
				if (!debug1.wasPressed())
					return;
			} while(debug1.wasPressed());

			// do something
		});
	}
}