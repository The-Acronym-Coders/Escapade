package com.teamacronymcoders.escapade.datagen.impl.recipe;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;

import java.util.function.Consumer;

public class EscapadeShapelessRecipeProvider extends RecipeProvider {

    public EscapadeShapelessRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {

    }

    @Override
    public String getName() {
        return "Escapade Recipe Provider: Shapeless";
    }
}
