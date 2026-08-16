package minecoders.progressive.api;

/**
 * An implementation of {@link BaseLockingSetting} for public usage.
 * @see BaseLockingSetting
 * @param <T> The value type
 */
public class PublicLockingSetting<T> extends BaseLockingSetting<T> {
    /**
     * Constructs a new locking setting with the given default value.
     * @param value The default value
     */
    public PublicLockingSetting(final T value) {
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