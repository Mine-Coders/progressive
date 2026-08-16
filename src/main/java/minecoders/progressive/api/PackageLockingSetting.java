package minecoders.progressive.api;

import org.jetbrains.annotations.ApiStatus;

/**
 * An implementation of {@link BaseLockingSetting} where locking is reserved for Progressive.
 * @see BaseLockingSetting
 * @param <T> The value type
 */
@ApiStatus.Internal
public class PackageLockingSetting<T> extends BaseLockingSetting<T> {
    /**
     * Constructs a new locking setting with the given default value.
     * @param value The default value
     */
    public PackageLockingSetting(final T value) {
        super(value);
    }

    /**
     * Locks the setting, preventing further modification.
     */
    @Override
    public synchronized boolean lock() {
        return super.lock();
    }

    /**
     * Locks the option and returns its value.
     * @return The current value of the {@link BaseLockingSetting}
     */
    @Override
    public T lockAndGet() {
        return super.lockAndGet();
    }
}