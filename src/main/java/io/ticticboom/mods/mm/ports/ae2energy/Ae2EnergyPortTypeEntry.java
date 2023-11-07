package io.ticticboom.mods.mm.ports.ae2energy;

import com.google.gson.JsonObject;
import io.ticticboom.mods.mm.Ref;
import io.ticticboom.mods.mm.ports.base.IConfiguredIngredient;
import io.ticticboom.mods.mm.ports.base.IConfiguredPort;
import io.ticticboom.mods.mm.ports.base.MMPortTypeEntry;
import io.ticticboom.mods.mm.ports.base.PortStorage;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class Ae2EnergyPortTypeEntry extends MMPortTypeEntry {
    @Override
    public Class<? extends PortStorage> storageClass() {
        return Ae2EnergyPortStorage.class;
    }

    @Override
    public IConfiguredPort parse(JsonObject element) {
        var ae_energy = element.get("capacity").getAsInt();
        return new Ae2EnergyConfiguredPort(ae_energy);
    }

    @Override
    public IConfiguredIngredient parseIngredient(JsonObject json) {
        var ae_energy = json.get("capacity").getAsInt();
        return new Ae2EnergyConfiguredIngredient(ae_energy);
    }

    @Override
    public ResourceLocation overlay(boolean input) {
        return input ? Ref.res("block/base_ports/ae_energy_input_cutout") : Ref.res("block/base_ports/ae_energy_output_cutout");
    }

    @Override
    public PortStorage createStorage(IConfiguredPort config) {
        return new Ae2EnergyPortStorage(((Ae2EnergyConfiguredPort) config).capacity());
    }

    @Override
    public boolean processInputs(IConfiguredIngredient ingredient, List<PortStorage> storage) {
        return false;
    }

    @Override
    public boolean processOutputs(IConfiguredIngredient ingredient, List<PortStorage> storage) {
        return false;
    }
}
