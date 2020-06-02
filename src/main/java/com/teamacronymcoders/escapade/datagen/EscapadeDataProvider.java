package com.teamacronymcoders.escapade.datagen;

import com.teamacronymcoders.escapade.Escapade;
import com.teamacronymcoders.escapade.datagen.impl.advancement.EscapadeAdvancementProvider;
import com.teamacronymcoders.escapade.datagen.impl.lang.EscapadeEnglishLangProvider;
import com.teamacronymcoders.escapade.datagen.impl.lang.EscapadeSwedishLangProvider;
import com.teamacronymcoders.escapade.datagen.impl.loottable.EscapadeBlockLootTableProvider;
import com.teamacronymcoders.escapade.datagen.impl.loottable.EscapadeEntityLootTableProvider;
import com.teamacronymcoders.escapade.datagen.impl.recipe.EscapadeShapedRecipeProvider;
import com.teamacronymcoders.escapade.datagen.impl.recipe.EscapadeShapelessRecipeProvider;
import com.teamacronymcoders.escapade.datagen.impl.tags.EscapadeBlockTagProvider;
import com.teamacronymcoders.escapade.datagen.impl.tags.EscapadeEntityTagProvider;
import com.teamacronymcoders.escapade.datagen.impl.tags.EscapadeItemTagProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(modid = Escapade.MODID, bus = Bus.MOD)
public class EscapadeDataProvider {

    @SubscribeEvent
    public static void gatherDataProviders(GatherDataEvent event) {
        final DataGenerator generator = event.getGenerator();

        if (event.includeClient()) {
            generator.addProvider(new EscapadeEnglishLangProvider(generator));
            generator.addProvider(new EscapadeSwedishLangProvider(generator));
        }

        if (event.includeServer()) {
            // Advancements
            generator.addProvider(new EscapadeAdvancementProvider(generator));

            // Loot Tables
            generator.addProvider(new EscapadeBlockLootTableProvider(generator));
            generator.addProvider(new EscapadeEntityLootTableProvider(generator));

            // Recipe
            generator.addProvider(new EscapadeShapedRecipeProvider(generator));
            generator.addProvider(new EscapadeShapelessRecipeProvider(generator));

            // Tags
            generator.addProvider(new EscapadeBlockTagProvider(generator));
            generator.addProvider(new EscapadeEntityTagProvider(generator));
            generator.addProvider(new EscapadeItemTagProvider(generator));
        }
    }

}
