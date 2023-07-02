package net.molodec.molomenumod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.molodec.MoloMenuClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;

@Mod(MoloMenuMod.MOD_ID)
// это класс
public class MoloMenuMod {
    public static final String MOD_ID = "molomenumod";

    public static final Logger LOGGER = LogManager.getLogger();

    public MoloMenuMod() {
        LOGGER.info("This is private place, Saudade Studios entry is prohibited");
        MinecraftForge.EVENT_BUS.addListener(this::OpenGui);
    }

    @OnlyIn(Dist.CLIENT)
    public void OpenGui(GuiOpenEvent event) {
        if (event.getGui() instanceof MainMenuScreen) {
            LOGGER.info("This is private place, Saudade Studios entry is prohibited");
            event.setGui(new MoloMenuClass());
        }
    }
}