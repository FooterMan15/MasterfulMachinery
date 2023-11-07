package io.ticticboom.mods.mm.ports.ae2energy;

import io.ticticboom.mods.mm.ports.base.IConfiguredIngredient;

public record Ae2EnergyConfiguredIngredient(
        int capacity
) implements IConfiguredIngredient {
}
