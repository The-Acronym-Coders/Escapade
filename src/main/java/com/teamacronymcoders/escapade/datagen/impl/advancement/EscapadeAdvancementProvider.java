package com.teamacronymcoders.escapade.datagen.impl.advancement;

import com.teamacronymcoders.escapade.datagen.ExtendableAdvancementProvider;
import net.minecraft.data.DataGenerator;

public class EscapadeAdvancementProvider extends ExtendableAdvancementProvider {

    public EscapadeAdvancementProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public String getName() {
        return "Escapade Advancement Provider";
    }
}
