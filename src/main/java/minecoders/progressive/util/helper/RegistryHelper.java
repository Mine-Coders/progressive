package minecoders.progressive.util.helper;

import minecoders.progressive.Progressive;
import net.minecraft.block.Block;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class RegistryHelper {
    public static RegistryKey<Item> getKeyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Progressive.id(name));
    }

    public static RegistryKey<Block> getKeyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Progressive.id(name));
    }

    public static RegistryKey<DamageType> getKeyOfDamageType(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Progressive.id(name));
    }
}
