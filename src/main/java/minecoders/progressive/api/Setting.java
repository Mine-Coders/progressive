package minecoders.progressive.api;

import minecoders.progressive.Progressive;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>An API setting that uses the value with the highest priority</p>
 * @param <T> The value type
 */
@SuppressWarnings("unused")
public class Setting<T> {
    protected final T defaultValue;
    protected T value;
    protected int priority = 0;

    protected final List<SettingChangeListener<T>> listeners = new CopyOnWriteArrayList<>();

    /**
     * Constructs a new setting with the given default value.
     * @param value The default value
     */
    public Setting(final T value) {
        this.defaultValue = value;
        this.value = value;
    }

    /**
     * @return The priority of the current value.
     */
    public synchronized int getPriority() {
        return priority;
    }

    /**
     * @return The current value.
     */
    public synchronized T get() {
        return value;
    }

    /**
     * @return The default value.
     */
    public T getDefaultValue() {
        return defaultValue;
    }

    /**
     * @return Whether the current value is equal to the default value.
     */
    public synchronized boolean isDefault() {
        return Objects.equals(value, defaultValue);
    }

    /**
     * @return Whether the setting has been configured by a user.
     */
    public synchronized boolean isUserConfigured() {
        return false;
    }

    /**
     * Sets the value of the setting depending on the priority. The provided priority value is used to determine
     * whether the new value should replace the old value with higher priority values overriding lower priority values.
     * @param value The new value
     * @param priority The priority of the value
     * @return Whether the value was changed
     *
     * @apiNote Default priority values override other default priority values
     */
    public boolean set(final T value, final int priority) {
        final T oldValue;
        final int oldPriority;

        synchronized (this) {
            oldPriority = this.priority;

            if (priority <= oldPriority && (oldPriority != 0 || priority != 0))
                return false;

            oldValue = this.value;

            this.priority = priority;
            this.value = value;
        }

        for (SettingChangeListener<T> listener : listeners) {
            try {
                listener.onChanged(this, oldValue, value, oldPriority, priority);
            } catch (Exception exception) {
                Progressive.LOGGER.error("Listener for Setting threw an exception", exception);
            }
        }

        return true;
    }

    /**
     * Sets the value of the setting depending on the priority. The provided priority value is used to determine
     * whether the new value should replace the old value with higher priority values overriding lower priority values.
     * @param value The new value
     * @param priority The priority of the value
     * @return Whether the value was changed
     *
     * @apiNote Default priority values override other default priority values
     */
    public boolean set(final T value, final Priority priority) {
        return set(value, priority.value);
    }

    /**
     * Adds the given setting change listener.
     * @param listener The listener
     */
    public boolean addListener(final SettingChangeListener<T> listener) {
        return listeners.add(listener);
    }

    /**
     * Removes the given setting change listener.
     * @param listener The listener
     */
    public boolean removeListener(final SettingChangeListener<T> listener) {
        return listeners.remove(listener);
    }

    @FunctionalInterface
    public interface SettingChangeListener<T> {
        void onChanged(Setting<T> setting, final T oldValue, final T newValue, int oldPriority, int newPriority);
    }

    @SuppressWarnings("unused")
    public enum Priority {
        DEFAULT(0),
        LOW(1000),
        MEDIUM(2000),
        HIGH(3000);

        public final int value;

        Priority(int value) {
            this.value = value;
        }
    }
}
