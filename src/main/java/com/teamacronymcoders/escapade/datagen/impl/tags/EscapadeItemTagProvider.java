package com.teamacronymcoders.escapade.datagen.impl.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;

public class EscapadeItemTagProvider extends ItemTagsProvider {

    public EscapadeItemTagProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerTags() {

    }

    @Override
    public String getName() {
        return "Escapade Tag Provider: Tags<Item>";
    }
}
