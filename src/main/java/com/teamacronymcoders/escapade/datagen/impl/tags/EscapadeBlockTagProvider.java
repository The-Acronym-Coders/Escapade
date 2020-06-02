package com.teamacronymcoders.escapade.datagen.impl.tags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;

public class EscapadeBlockTagProvider extends BlockTagsProvider {

    public EscapadeBlockTagProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerTags() {

    }

    @Override
    public String getName() {
        return "Escapade Tag Provider: Tags<Block>";
    }
}
