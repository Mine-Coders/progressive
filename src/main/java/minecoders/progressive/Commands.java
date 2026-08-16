package minecoders.progressive;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.CommandManager.RegistrationEnvironment;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

@SuppressWarnings("unused")
public class Commands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess, RegistrationEnvironment environment) {
        LiteralArgumentBuilder<ServerCommandSource> exampleCommand = CommandManager.literal("exampleexample");
        exampleCommand.executes(context -> {
            context.getSource().sendFeedback(
                () -> Text.literal("pussy").formatted(Formatting.RED),
                false
            );

            return 0;
        });

        dispatcher.register(exampleCommand);
    }
}
