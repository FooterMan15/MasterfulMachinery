package io.ticticboom.mods.mm.ports.ae2energy.jei;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.PoseStack;
import io.ticticboom.mods.mm.Ref;
import io.ticticboom.mods.mm.util.Deferred;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredientRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class Ae2EnergyIngredientRenderer implements IIngredientRenderer<Ae2EnergyStack> {
    public Deferred<IJeiHelpers> helpers;

    public Ae2EnergyIngredientRenderer(Deferred<IJeiHelpers> helpers) {
        this.helpers = helpers;
    }

    @Override
    public void render(PoseStack stack, Ae2EnergyStack ingredient) {
        helpers.data.getGuiHelper().createDrawable(Ref.SLOT_PARTS, 1, 98, 16, 16).draw(stack);
    }

    @Override
    public List<Component> getTooltip(Ae2EnergyStack ingredient, TooltipFlag tooltipFlag) {
        return Lists.newArrayList(
            Component.literal("AE2 Energy")
        );
    }
}
