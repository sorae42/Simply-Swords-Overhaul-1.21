package net.jrdemiurge.simplyswordsoverhaul;

import com.mojang.logging.LogUtils;
import net.jrdemiurge.simplyswordsoverhaul.scheduler.Scheduler;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.server.ServerStartingEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SimplySwordsOverhaul.MOD_ID)
public class SimplySwordsOverhaul
{
    public static final String MOD_ID = "simply_swords_overhaul";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SimplySwordsOverhaul(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new Scheduler());

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
