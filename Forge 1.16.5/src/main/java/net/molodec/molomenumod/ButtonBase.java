package net.molodec.molomenumod;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import org.jetbrains.annotations.NotNull;

public class ButtonBase extends net.minecraft.client.gui.widget.button.Button {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final ITextComponent text;
    private final ResourceLocation texLocation;

    public ButtonBase(int x, int y, int width, int height, ITextComponent text, IPressable onPress, ResourceLocation texture) {
        super(x, y, width, height, text, onPress);
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.text = text;
        this.texLocation = texture;
    }

    public ButtonBase(int x, int y, int width, int height, String text, IPressable onPress, ResourceLocation texture) {
        this(x, y, width, height, new StringTextComponent(text), onPress, texture);
    }

    public ButtonBase(int x, int y, int width, int height, IPressable onPress, ResourceLocation texture) {
        this(x, y, width, height, "", onPress, texture);
    }

    @Override
    public void render(@NotNull MatrixStack stack, int x, int y, float f) {
        Minecraft minecraft = Minecraft.getInstance();
        FontRenderer fr = minecraft.font;
        stack.pushPose();
        stack.translate(0.0D, 0.0D, 100.0D);

        stack.popPose();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        int j = getFGColor();
        Minecraft.getInstance().textureManager.bind(texLocation);
        blit(stack, this.x, this.y, 0, isCursorAtButton(x, y) ? this.height : 0, this.width, this.height, this.width, this.height * 2);
        drawCenteredString(stack, fr, this.text, this.x + this.width / 2, this.y + (this.height - 8) / 2, j | MathHelper.ceil(this.alpha * 255.0F) << 24);

    }

    public boolean isCursorAtButton(int cursorX, int cursorY) {
        return cursorX >= this.x && cursorY >= this.y && cursorX <= this.x + this.width && cursorY <= this.y + this.height;
    }
}
