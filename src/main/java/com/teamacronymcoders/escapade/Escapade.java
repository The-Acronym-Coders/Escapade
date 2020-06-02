package com.teamacronymcoders.escapade;

import com.teamacronymcoders.escapade.datagen.impl.loottable.EscapadeEntityLootTableProvider.EscapadeEntityLootTables;
import com.teamacronymcoders.escapade.registry.EscapadeEntityRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("escapade")
public class Escapade {
    public static final String MODID = "escapade";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Escapade() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        runDeferredRegistries(eventBus);
    }

    private void runDeferredRegistries(IEventBus bus) {
        EscapadeEntityRegistration.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }
}
