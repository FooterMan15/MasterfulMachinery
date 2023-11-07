package io.ticticboom.mods.mm.compat.jei.port.ae2;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import io.ticticboom.mods.mm.compat.jei.base.JeiPortTypeEntry;
import io.ticticboom.mods.mm.ports.ae2energy.Ae2EnergyConfiguredIngredient;
import io.ticticboom.mods.mm.ports.ae2energy.jei.Ae2EnergyIngredientHelper;
import io.ticticboom.mods.mm.ports.ae2energy.jei.Ae2EnergyIngredientRenderer;
import io.ticticboom.mods.mm.ports.ae2energy.jei.Ae2EnergyIngredientType;
import io.ticticboom.mods.mm.ports.ae2energy.jei.Ae2EnergyStack;
import io.ticticboom.mods.mm.ports.base.IConfiguredIngredient;
import io.ticticboom.mods.mm.setup.model.RecipeModel;
import io.ticticboom.mods.mm.util.Deferred;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.registration.IModIngredientRegistration;

public class Ae2EnergyJeiPortTypeEntry extends JeiPortTypeEntry {
    public static final Ae2EnergyIngredientType AE_STACK = new Ae2EnergyIngredientType();
    @Override
    public void registerJeiIngredient(IModIngredientRegistration registration, Deferred<IJeiHelpers> helpers) {
        registration.register(AE_STACK, ImmutableList.of(), new Ae2EnergyIngredientHelper(), new Ae2EnergyIngredientRenderer(helpers));
    }

    @Override
    public void renderJei(RecipeModel recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY, IConfiguredIngredient ing, IJeiHelpers helpers, boolean input, int x, int y) {
        helpers.getGuiHelper().getSlotDrawable().draw(stack, x - 1, y - 1);
    }

    @Override
    public void setupRecipeJei(IConfiguredIngredient ingredient, IRecipeLayoutBuilder builder, RecipeModel recipe, IFocusGroup focuses, IRecipeSlotBuilder slot, boolean input, int x, int y) {
        var conf = (Ae2EnergyConfiguredIngredient) ingredient;
        slot.addIngredient(AE_STACK, new Ae2EnergyStack(conf.capacity()));
    }
}
