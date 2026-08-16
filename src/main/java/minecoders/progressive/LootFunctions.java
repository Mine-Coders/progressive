package minecoders.progressive;

import com.mojang.serialization.MapCodec;
import minecoders.progressive.loot.functions.Example;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class LootFunctions {
    public static final LootFunctionType<Example> EXAMPLED = register("example", Example.CODEC);

    public static <T extends LootFunction> LootFunctionType<T>
    register(String name, MapCodec<T> codec) {
        LootFunctionType<T> lootFunctionType = new LootFunctionType<>(codec);

        Registry.register(
            Registries.LOOT_FUNCTION_TYPE,
            Progressive.id(name),
            lootFunctionType
        );

        return lootFunctionType;
    }

    public static void initialize() {
        Progressive.LOGGER.debug("Initialized Loot Functions");
    }
}