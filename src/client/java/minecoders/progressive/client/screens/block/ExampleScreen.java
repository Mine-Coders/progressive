package minecoders.progressive.client.screens.block;

import minecoders.progressive.Progressive;
import minecoders.progressive.screen.ExampleScreenHandler;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class ExampleScreen extends HandledScreen<ExampleScreenHandler> {
    private static final Identifier TEXTURE = Progressive.id("textures/gui/container/example.png");
    private static final Identifier COMBINE_PROGRESS_TEXTURE = Progressive.id("container/example/progress");
    private static final int PROGRESS_WIDTH = 24;
    private static final int PROGRESS_HEIGHT = 16;

    public ExampleScreen(ExampleScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0F, 0F, backgroundWidth, backgroundHeight, 256, 256);

        int combineProgress = MathHelper.ceil(this.handler.getCombineProgress() * (float) PROGRESS_WIDTH);

        context.drawGuiTexture(
            RenderPipelines.GUI_TEXTURED,
            COMBINE_PROGRESS_TEXTURE,
            PROGRESS_WIDTH,
            PROGRESS_HEIGHT,
            0,
            0,
            x + 97,
            y + 34,
            combineProgress,
            PROGRESS_HEIGHT
        );
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
