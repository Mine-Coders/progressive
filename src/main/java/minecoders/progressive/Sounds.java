package minecoders.progressive;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Random;

@SuppressWarnings("unused")
public class Sounds {
    public static final SoundEvent EXAMPLE = register("example");

    public static SoundEvent register(String name) {
        Identifier identifier = Progressive.id(name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void initialize() {
        Progressive.LOGGER.debug("Initialized Sounds");
    }
}
