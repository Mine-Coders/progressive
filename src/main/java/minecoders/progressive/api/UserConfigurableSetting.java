package minecoders.progressive.api;

import minecoders.progressive.Integrations;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * <p>Similar to {@link Setting} but linked to a user configurable setting.</p>
 * @param <T> The value type
 */
@SuppressWarnings("unused")
public class UserConfigurableSetting<T> extends Setting<T> {
    protected final Supplier<T> configurationSupplier;

    /**
     * Constructs a new user configurable setting with the given default value and user configuration supplier.
     * @param value The default value
     */
    public UserConfigurableSetting(final T value, final Supplier<T> configurationSupplier) {
        super(value);
        this.configurationSupplier = configurationSupplier;
    }

    /**
     * @return Whether the current value is equal to the default value.
     */
    public synchronized boolean isValueDefault() {
        return super.isDefault();
    }

    /**
     * @return Whether the user configured value is equal to the default value, or in other words whether a user has changed a configuration.
     */
    public synchronized boolean isConfigurationDefault() {
        return !Integrations.isMidnightLoaded || Objects.equals(configurationSupplier.get(), defaultValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean isDefault() {
        return Objects.equals(get(), defaultValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean isUserConfigured() {
        return Integrations.isMidnightLoaded && priority <= 0 && !Objects.equals(configurationSupplier.get(), defaultValue);
    }

    /**
     * @return The current value.
     */
    public T getValue() {
        return super.get();
    }

    /**
     * @return The user configured value.
     */
    public synchronized T getConfiguration() {
        return (Integrations.isMidnightLoaded)
            ? configurationSupplier.get()
            : defaultValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized T get() {
        if (!Integrations.isMidnightLoaded)
            return super.get();

        final T configuration = configurationSupplier.get();

        if (priority > 0 || Objects.equals(configuration, defaultValue))
            return super.get();

        return configurationSupplier.get();

    }
}
