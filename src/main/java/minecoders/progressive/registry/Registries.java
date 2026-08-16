package minecoders.progressive.registry;

import net.minecraft.entity.EntityType;

public class Registries {
    public static final UniqueRegistry<EntityType<?>> Example = new UniqueRegistry<>(net.minecraft.registry.Registries.ENTITY_TYPE::getId);
}
