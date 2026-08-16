package minecoders.progressive.loot.functions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import minecoders.progressive.LootFunctions;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.LootFunctionType;

import java.util.List;

public class Example extends ConditionalLootFunction {
    public static final MapCodec<Example> CODEC =
        RecordCodecBuilder.mapCodec(instance ->
            addConditionsField(instance)
                .apply(instance, Example::new)
        );

    public Example(List<LootCondition> conditions) {
        super(conditions);
    }

    @Override
    protected ItemStack process(ItemStack stack, LootContext context) {
        return stack;
    }

    @Override
    public LootFunctionType<? extends ConditionalLootFunction> getType() {
        return LootFunctions.EXAMPLED;
    }
}