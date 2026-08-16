package minecoders.progressive;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Components {
    public static final ComponentType<Boolean> EXAMPLE = register("example", Codec.BOOL);

    public static <T> ComponentType<T> register(String name, Codec<T> codec) {
        return Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Progressive.id(name),
            ComponentType.<T>builder().codec(codec).build()
        );
    }

    protected static void initialize() {
        Progressive.LOGGER.info("Registering components");
    }
}