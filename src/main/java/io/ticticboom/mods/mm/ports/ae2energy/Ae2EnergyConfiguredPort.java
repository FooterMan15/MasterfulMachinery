package io.ticticboom.mods.mm.ports.ae2energy;

import io.ticticboom.mods.mm.ports.base.IConfiguredPort;

public record Ae2EnergyConfiguredPort(
        int capacity
) implements IConfiguredPort {
}
