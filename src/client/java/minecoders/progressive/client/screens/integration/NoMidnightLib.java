package minecoders.progressive.client.screens.integration;

import minecoders.progressive.client.util.screen.BoundDimensions;
import minecoders.progressive.client.util.screen.CachingDimensions;
import minecoders.progressive.client.util.screen.Screen;
import minecoders.progressive.client.util.screen.SimpleDimensions;
import minecoders.progressive.util.helper.TranslationHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

public class NoMidnightLib extends Screen {
    public final BoundDimensions<CachingDimensions<SimpleDimensions<?>>> EXIT_BUTTON_DIMENSIONS;

    public NoMidnightLib(net.minecraft.client.gui.screen.Screen parent) {
        super(parent);

        EXIT_BUTTON_DIMENSIONS = new BoundDimensions<>(
            this,
            new CachingDimensions<>(
                new SimpleDimensions<>()
                    .setPosition(0.5, 0.575)
                    .setSize(0.16, 0.06)
                    .setAnchor(0.5, 0.5)
            )
        );
    }

    @Override
    protected void addDrawables(@NotNull MinecraftClient client) {
        ButtonWidget buttonWidget = ButtonWidget.builder(
            TranslationHelper.screen("nomidnightlib.button.exit.text"),
            b -> close()
        ).dimensions(
            EXIT_BUTTON_DIMENSIONS.getX(), EXIT_BUTTON_DIMENSIONS.getY(),
            EXIT_BUTTON_DIMENSIONS.getWidth(), EXIT_BUTTON_DIMENSIONS.getHeight()
        ).build();

        addDrawableChild(buttonWidget);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        Text helpText = TranslationHelper.screen("nomidnightlib.label.help.text");
        String translatedHelpText = I18n.translate(
            ((TranslatableTextContent) helpText.getContent()).getKey(),
            ((TranslatableTextContent) helpText.getContent()).getArgs()
        );

        context.drawText(this.textRenderer, helpText, this.width / 2 - this.textRenderer.getWidth(translatedHelpText) / 2, this.height / 2 - this.textRenderer.fontHeight / 2, 0xFFFFFFFF, true);
    }
}
