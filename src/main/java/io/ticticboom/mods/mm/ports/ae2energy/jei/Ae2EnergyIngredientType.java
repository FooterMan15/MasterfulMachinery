package io.ticticboom.mods.mm.ports.ae2energy.jei;

import mezz.jei.api.ingredients.IIngredientType;

public class Ae2EnergyIngredientType implements IIngredientType<Ae2EnergyStack> {
    @Override
    public Class<? extends Ae2EnergyStack> getIngredientClass() {
        return Ae2EnergyStack.class;
    }
}
