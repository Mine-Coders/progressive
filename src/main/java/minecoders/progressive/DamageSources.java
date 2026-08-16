package minecoders.progressive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class DamageSources {
    public static final RegistryKey<DamageType> EXAMPLE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Progressive.id("stepping"));

    public static DamageSource getExampleDamage(World world) {
        return get(world, EXAMPLE);
    }

    public static DamageSource getExampleDamage(World world, Entity attacker) {
        return get(world, EXAMPLE, attacker);
    }

    public static DamageSource get(World world, RegistryKey<DamageType> registryKey) {
        return new DamageSource(
            world.getRegistryManager()
                .get(RegistryKeys.DAMAGE_TYPE)
                .entryOf(registryKey)
        );
    }

    public static DamageSource get(World world, RegistryKey<DamageType> registryKey, Entity attacker) {
        return new DamageSource(
            world.getRegistryManager()
                .get(RegistryKeys.DAMAGE_TYPE)
                .entryOf(registryKey),
            attacker
        );
    }

    public static void initialize() {
        Progressive.LOGGER.debug("Initialized Damage Sources");
    }
}
