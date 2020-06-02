package com.teamacronymcoders.escapade.datagen.impl.lang.base;

import com.teamacronymcoders.escapade.Escapade;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.List;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class EscapadeBaseLangProvider extends LanguageProvider {

    private final String locale;

    public EscapadeBaseLangProvider(DataGenerator gen, String locale) {
        super(gen, Escapade.MODID, locale);
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {}

    /**
     * Helper function to add advancements to the lang generator
     *
     * @param advancement The advancement for localizations to be added
     * @param title       The title of the advancement
     * @param description The description of the advancement
     */
    public void add(Advancement advancement, String title, String description) {
        final DisplayInfo display = advancement.getDisplay();
        add(display.getTitle().getUnformattedComponentText(), title);
        add(display.getDescription().getUnformattedComponentText(), description);
    }

    public void add(String translation, Block... blocks) {
        for (Block block : blocks) {
            add(block, translation);
        }
    }

    public void add(String translation, Item... items) {
        for (Item item : items) {
            add(item, translation);
        }
    }

    public <B> void addColored(List<B> objects, Function<B, DyeColor> color, BiConsumer<B, String> consumer, String inputString) {
        for (B b : objects) {
            String str = color.apply(b).getName();
            String name;
            if (str.contains("_")) {
                String[] strings = str.split("_");
                StringBuilder builder = new StringBuilder();
                boolean firstString = true;
                for (String string : strings) {
                    builder.append(string.substring(0, 1).toUpperCase(Locale.ROOT)).append(string.substring(1));
                    if (firstString) {
                        builder.append("-");
                        firstString = false;
                    }
                }
                name = builder.toString() + inputString;
                consumer.accept(b, name);
                continue;
            }
            name = str.substring(0, 1).toUpperCase(Locale.ROOT) + str.substring(1) + inputString;
            consumer.accept(b, name);
        }
    }

    @Override
    public String getName() {
        return "Escapade Language Provider: " + locale;
    }
}
