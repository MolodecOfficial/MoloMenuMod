package net.molodec;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.client.gui.screen.ModListScreen;
import net.molodec.molomenumod.ButtonBase;


public class MoloMenuClass extends Screen {
    public MoloMenuClass() {
        super(new TranslationTextComponent("narrator.screen.title"));
    }
    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float partialTick) {
        Minecraft.getInstance().textureManager.bind(new ResourceLocation("molomenumod", "textures/background.png"));
        blit(stack, 0, 0, 0, 0, width, height, width, height);
        super.render(stack, mouseX, mouseY, partialTick);
    }

    protected void init() {
        int j = this.height / 4 + 48;
        this.createNormalMenuOptions();
        this.addButton(new ButtonBase(0, this.height / 2 + 0, 160, 20, new TranslationTextComponent("menu.options"),
                (p_213096_1_) -> this.minecraft.setScreen(new OptionsScreen(this, this.minecraft.options)), new ResourceLocation("molomenumod", "textures/gui/settings.png")));
        this.addButton(new ButtonBase(0, this.height / 2 + 25, 145, 20, new TranslationTextComponent("menu.quit"),
                (p_213094_1_) -> this.minecraft.stop(), new ResourceLocation("molomenumod","textures/gui/quit.png")));
    };

    private void createNormalMenuOptions() {
        this.addButton(new ButtonBase(0, this.height / 2 - 50, 190, 20, new TranslationTextComponent("menu.singleplayer"),
                (p_213089_1_) -> this.minecraft.setScreen(new WorldSelectionScreen(this)), new ResourceLocation("molomenumod", "textures/gui/singleplayer.png")));
        this.addButton(new ButtonBase(0, this.height / 2 - 25, 175, 20, new TranslationTextComponent("menu.multiplayer"), (button) -> {
            Screen screen = (Screen) (this.minecraft.options.skipMultiplayerWarning ? new MultiplayerScreen(this) : new MultiplayerWarningScreen(this));
            this.minecraft.setScreen(screen);
        }, new ResourceLocation("molomenumod", "textures/gui/multiplayer.png")));
    }
}
