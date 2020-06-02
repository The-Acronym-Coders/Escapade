package com.teamacronymcoders.escapade.datagen.impl.loottable;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.teamacronymcoders.escapade.Escapade;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootParameterSet;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraft.world.storage.loot.LootTable.Builder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class EscapadeBlockLootTableProvider extends LootTableProvider {

    public EscapadeBlockLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables() {
        return Lists.newArrayList(
            Pair.of(EscapadeBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    public String getName() {
        return "Escapade LootTable Provider: Block";
    }

    public static class EscapadeBlockLootTables extends BlockLootTables {
        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream()
                .filter(entity -> Optional.ofNullable(entity.getRegistryName())
                    .filter(registryName -> registryName.getNamespace().equals(Escapade.MODID)).isPresent()
                ).collect(Collectors.toList());
        }

        @Override
        protected void addTables() {

        }
    }

}
