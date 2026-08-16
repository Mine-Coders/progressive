package minecoders.progressive;

import minecoders.progressive.util.helper.RegistryHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.Optional;

@SuppressWarnings("unused")
public class DamageSources {
    public static final RegistryKey<DamageType> EXAMPLE = RegistryHelper.getKeyOfDamageType("example");

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static DamageSource getExampleDamage(World world) {
        return get(world, EXAMPLE).get();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static DamageSource getExampleDamage(World world, Entity attacker) {
        return get(world, EXAMPLE, attacker).get();
    }

    public static Optional<DamageSource> get(World world, RegistryKey<DamageType> registryKey) {
        Optional<RegistryEntry.Reference<DamageType>> reference = world.getRegistryManager()
            .getOrThrow(RegistryKeys.DAMAGE_TYPE)
            .getEntry(registryKey.getValue());

        return reference.map(DamageSource::new);
    }

    public static Optional<DamageSource> get(World world, RegistryKey<DamageType> registryKey, Entity attacker) {
        Optional<RegistryEntry.Reference<DamageType>> reference = world.getRegistryManager()
            .getOrThrow(RegistryKeys.DAMAGE_TYPE)
            .getEntry(registryKey.getValue());

        return reference.map(damageTypeReference -> new DamageSource(damageTypeReference, attacker));
    }

    public static void initialize() {
        Progressive.LOGGER.debug("Initialized Damage Sources");
    }
}
