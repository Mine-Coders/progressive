package minecoders.progressive.api.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

/**
 *
 */
public class Example {
    public interface ExampleInterface {
        void callback();
    }

    /**
     *
     */
    public static final Event<ExampleInterface> EXAMPLE = EventFactory.createArrayBacked(ExampleInterface.class, listeners -> () -> {

    });
}
