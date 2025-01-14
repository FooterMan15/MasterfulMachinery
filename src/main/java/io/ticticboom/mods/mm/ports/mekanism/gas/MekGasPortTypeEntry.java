package io.ticticboom.mods.mm.ports.mekanism.gas;

import io.ticticboom.mods.mm.Ref;
import io.ticticboom.mods.mm.ports.base.IConfiguredPort;
import io.ticticboom.mods.mm.ports.base.PortStorage;
import io.ticticboom.mods.mm.ports.mekanism.MekChemicalConfiguredPort;
import io.ticticboom.mods.mm.ports.mekanism.MekChemicalPortTypeEntry;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import net.minecraft.resources.ResourceLocation;

public class MekGasPortTypeEntry extends MekChemicalPortTypeEntry<Gas, GasStack> {
    public MekGasPortTypeEntry() {
        super("gas");
    }

    @Override
    public Class<? extends PortStorage> storageClass() {
        return MekGasPortStorage.class;
    }

    @Override
    public ResourceLocation overlay(boolean input) {
        return input ? Ref.res("block/compat_ports/mekanism_gas_input_cutout") : Ref.res("block/compat_ports/mekanism_gas_output_cutout");
    }

    @Override
    public PortStorage createStorage(IConfiguredPort config) {
        return new MekGasPortStorage((MekChemicalConfiguredPort) config);
    }
}
