package com.teamacronymcoders.escapade.datagen.impl.lang;

import com.teamacronymcoders.escapade.datagen.impl.lang.base.EscapadeBaseLangProvider;
import com.teamacronymcoders.escapade.registry.EscapadeEntityRegistration;
import net.minecraft.data.DataGenerator;

public class EscapadeSwedishLangProvider extends EscapadeBaseLangProvider {

    public EscapadeSwedishLangProvider(DataGenerator gen) {
        super(gen, "sv_se");
    }

    @Override
    protected void addTranslations() {
        addEntities();
    }

    private void addEntities() {
        add(EscapadeEntityRegistration.TREASURE_PIG.get(), "Klenod Grisen");
    }
}
