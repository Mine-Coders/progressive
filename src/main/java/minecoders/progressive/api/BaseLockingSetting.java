package minecoders.progressive.api;

/**
 * <p>Similar to {@link Setting}, but provides the ability to lock the setting, rejecting attempted updates</p>
 * @see Setting
 * @param <T> The value type
 */
@SuppressWarnings("unused")
public abstract class BaseLockingSetting<T> extends Setting<T> {
    protected volatile boolean locked = false;

    /**
     * Constructs a new locking setting with the given default value.
     * @param value The default value
     */
    protected BaseLockingSetting(final T value) {
        super(value);
    }

    /**
     * Sets the value of the setting depending on the priority. The provided priority value is used to determine
     * whether the new value should replace the old value with higher priority values overriding lower priority values.
     * @param value The new value
     * @param priority The priority of the value
     * @return Whether the value was changed
     *
     * @apiNote When the setting is locked, calls to this method are ignored.
     * @apiNote Default priority values override other default priority values
     */
    @Override
    public boolean set(final T value, final int priority) {
        if (this.locked)
            return false;

        return super.set(value, priority);
    }

    /**
     * @return Whether the option is locked.
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Adds the given setting change listener.
     * @param listener The listener
     * @apiNote When the setting is locked, calls to this method are ignored.
     */
    @Override
    public boolean addListener(SettingChangeListener<T> listener) {
        if (this.locked)
            return false;

        return super.addListener(listener);
    }

    /**
     * Locks the setting, preventing further modification.
     */
    protected synchronized boolean lock() {
        if (this.locked)
            return false;

        listeners.clear();
        this.locked = true;
        return true;
    }

    /**
     * Locks the option and returns its value.
     * @return The current value of the {@link BaseLockingSetting}
     */
    protected T lockAndGet() {
        lock();
        return get();
    }
}
