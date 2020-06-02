package com.teamacronymcoders.escapade.registry;

import com.teamacronymcoders.escapade.Escapade;
import com.teamacronymcoders.escapade.entity.treasurepig.TreasurePigEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EscapadeEntityRegistration {

    private static final DeferredRegister<EntityType<?>> ENTITY = new DeferredRegister<>(ForgeRegistries.ENTITIES, Escapade.MODID);

    public static RegistryObject<EntityType<TreasurePigEntity>> TREASURE_PIG = ENTITY.register("treasure_pig", () -> EntityType.Builder.<TreasurePigEntity>create(TreasurePigEntity::new, EntityClassification.CREATURE).build("treasure_pig"));

    public static void register(IEventBus bus) {
        ENTITY.register(bus);
    }
}
