package minecoders.progressive.client.util.screen.widget;

import minecoders.progressive.Progressive;
import minecoders.progressive.client.util.screen.BoundDimensions;
import minecoders.progressive.client.util.screen.Dimensions;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BackgroundWidget extends ClickableWidget {
    public static final Identifier backgroundTextureId = Identifier.of(Progressive.MOD_ID, "background");
    public BackgroundWidget(int x, int y, int width, int height) {
        super(x, y, width, height, Text.empty());
    }

    public <T extends Dimensions> BackgroundWidget(Screen screen, T dimensions) {
        this(
            dimensions.getX(screen),
            dimensions.getY(screen),
            dimensions.getWidth(screen),
            dimensions.getHeight(screen)
        );
    }

    public <T extends BoundDimensions<?>> BackgroundWidget(T dimensions) {
        this(dimensions.getScreen(), dimensions);
    }

    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawGuiTexture(
            RenderPipelines.GUI_TEXTURED,
            backgroundTextureId,
            getX(),
            getY(),
            width,
            height
        );
    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {}

    @Override
    public boolean mouseClicked(Click click, boolean doubled) {
        return false;
    }

    @Override
    public boolean mouseReleased(Click click) {
        return false;
    }

    @Override
    public boolean mouseDragged(Click click, double offsetX, double offsetY) {
        return false;
    }

    @Override
    public boolean isMouseOver(double mouseX, double mouseY) {
        return false;
    }
}
