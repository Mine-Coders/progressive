package minecoders.progressive.api.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * A Progressive Client Integration
 *
 * <p>In {@code fabric.mod.json}, the entrypoint is defined with {@code progressive-client} key</p>
 */
@FunctionalInterface
@Environment(EnvType.CLIENT)
public interface ProgressiveClientIntegration {
    void onProgressiveInitialize();
}
