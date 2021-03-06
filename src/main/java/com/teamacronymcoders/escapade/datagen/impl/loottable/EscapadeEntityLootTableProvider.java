package com.teamacronymcoders.escapade.datagen.impl.loottable;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.teamacronymcoders.escapade.Escapade;
import com.teamacronymcoders.escapade.datagen.impl.loottable.EscapadeBlockLootTableProvider.EscapadeBlockLootTables;
import com.teamacronymcoders.escapade.registry.EscapadeEntityRegistration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.LootTable.Builder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class EscapadeEntityLootTableProvider extends LootTableProvider {

    public EscapadeEntityLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables() {
        return Lists.newArrayList(
            Pair.of(EscapadeEntityLootTables::new, LootParameterSets.ENTITY)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {}

    @Override
    public String getName() {
        return "Escapade LootTable Provider: Entity";
    }

    public static class EscapadeEntityLootTables extends EntityLootTables {
        public static final ResourceLocation TREASURE_PIG = new ResourceLocation(Escapade.MODID, "entities/treasure_pig");

        @Override
        protected Iterable<EntityType<?>> getKnownEntities() {
            return ForgeRegistries.ENTITIES.getValues().stream()
                .filter(entity -> Optional.ofNullable(entity.getRegistryName())
                    .filter(registryName -> registryName.getNamespace().equals(Escapade.MODID)).isPresent()
                ).collect(Collectors.toList());
        }

        @Override
        protected void addTables() {
            this.registerLootTable(EscapadeEntityRegistration.TREASURE_PIG.get(), LootTable.builder()
                .addLootPool(new LootPool.Builder()
                    .rolls(ConstantRange.of(1))
                    .addEntry(AlternativesLootEntry.builder()
                        .alternatively(TableLootEntry.builder(LootTables.CHESTS_SIMPLE_DUNGEON))
                        .alternatively(TableLootEntry.builder(LootTables.CHESTS_ABANDONED_MINESHAFT))
                        .alternatively(TableLootEntry.builder(LootTables.CHESTS_DESERT_PYRAMID))
                        .alternatively(TableLootEntry.builder(LootTables.CHESTS_JUNGLE_TEMPLE))
                        .alternatively(TableLootEntry.builder(LootTables.CHESTS_WOODLAND_MANSION))
                    )
                )
            );
        }
    }
}
