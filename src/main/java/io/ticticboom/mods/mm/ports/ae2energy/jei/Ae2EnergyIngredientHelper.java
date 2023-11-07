package io.ticticboom.mods.mm.ports.ae2energy.jei;

import io.ticticboom.mods.mm.compat.jei.port.ae2.Ae2EnergyJeiPortTypeEntry;
import mezz.jei.api.ingredients.IIngredientHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class Ae2EnergyIngredientHelper implements IIngredientHelper<Ae2EnergyStack> {
    @Override
    public IIngredientType<Ae2EnergyStack> getIngredientType() {
        return Ae2EnergyJeiPortTypeEntry.AE_STACK;
    }

    @Override
    public String getDisplayName(Ae2EnergyStack ingredient) {
        return "AE2 Energy";
    }

    @Override
    public String getUniqueId(Ae2EnergyStack ingredient, UidContext context) {
        return "ae_energy" + ingredient.capacity;
    }

    @Override
    public ResourceLocation getResourceLocation(Ae2EnergyStack ingredient) {
        return new ResourceLocation("ae2");
    }

    @Override
    public Ae2EnergyStack copyIngredient(Ae2EnergyStack ingredient) {
        return new Ae2EnergyStack(ingredient.capacity);
    }

    @Override
    public String getErrorInfo(@Nullable Ae2EnergyStack ingredient) {
        return "Error";
    }
}
