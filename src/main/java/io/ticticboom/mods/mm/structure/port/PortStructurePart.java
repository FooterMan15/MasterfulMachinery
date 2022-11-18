package io.ticticboom.mods.mm.structure.port;

import com.google.gson.JsonObject;
import io.ticticboom.mods.mm.block.PortBlock;
import io.ticticboom.mods.mm.block.entity.PortBlockEntity;
import io.ticticboom.mods.mm.ports.base.IOPortStorage;
import io.ticticboom.mods.mm.structure.IConfiguredStructurePart;
import io.ticticboom.mods.mm.structure.MMStructurePart;
import io.ticticboom.mods.mm.structure.block.BlockConfiguredStructurePart;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class PortStructurePart extends MMStructurePart {

    @Override
    public IConfiguredStructurePart parse(JsonObject json) {
        var port = ResourceLocation.tryParse(json.get("port").getAsString());
        var input = json.get("input").getAsBoolean();
        return new PortConfiguredStructurePart(port, input);
    }

    @Override
    public boolean validatePlacement(Level level, BlockPos expectedPos, IConfiguredStructurePart config) {
        var conf = ((PortConfiguredStructurePart) config);
        var block = level.getBlockState(expectedPos).getBlock();
        if (block instanceof PortBlock port) {
            if (!port.model().port().equals(conf.port())) {
                return false;
            }
            if (conf.input() != port.model().input()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public Optional<IOPortStorage> getPortIfPresent(Level level, BlockPos expectedPos, IConfiguredStructurePart config) {
        var conf = ((PortConfiguredStructurePart) config);
        var block = level.getBlockEntity(expectedPos);
        if (block instanceof PortBlockEntity be) {
            return Optional.of(new IOPortStorage(be.storage, conf.input()));
        }
        return Optional.empty();
    }
}