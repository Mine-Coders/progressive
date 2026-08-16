package minecoders.progressive.api;

/**
 * A Progressive Integration
 *
 * <p>In {@code fabric.mod.json}, the entrypoint is defined with {@code progressive} key</p>
 */
@FunctionalInterface
public interface ProgressiveIntegration {
    void onProgressiveInitialize();
}
