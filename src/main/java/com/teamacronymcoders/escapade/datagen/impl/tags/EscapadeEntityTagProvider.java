package com.teamacronymcoders.escapade.datagen.impl.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;

public class EscapadeEntityTagProvider extends EntityTypeTagsProvider {

    public EscapadeEntityTagProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerTags() {

    }

    @Override
    public String getName() {
        return "Escapade Tag Provider: Tags<EntityType>";
    }
}
