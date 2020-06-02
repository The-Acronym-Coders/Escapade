package com.teamacronymcoders.escapade.datagen.impl.lang;

import com.teamacronymcoders.escapade.datagen.impl.lang.base.EscapadeBaseLangProvider;
import com.teamacronymcoders.escapade.registry.EscapadeEntityRegistration;
import net.minecraft.data.DataGenerator;

public class EscapadeEnglishLangProvider extends EscapadeBaseLangProvider {

    public EscapadeEnglishLangProvider(DataGenerator gen) {
        super(gen, "en_us");
    }

    @Override
    protected void addTranslations() {
        addEntities();
    }

    private void addEntities() {
        add(EscapadeEntityRegistration.TREASURE_PIG.get(), "Treasure Pig");
    }
}
