package io.ticticboom.mods.mm.ports.ae2energy;

import io.ticticboom.mods.mm.ports.base.PortStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;

public class Ae2EnergyPortStorage extends PortStorage {
    public Ae2EnergyConfiguredPort config;
    public int capacity;
    public boolean manualUpdate = false;

    public Ae2EnergyPortStorage(int capacity) {
        this.capacity = capacity;
    }

    public void read(CompoundTag tag) {
        capacity = tag.getInt("Capacity");
    }

    @Override
    public CompoundTag write() {
        var tag = new CompoundTag();
        tag.putInt("Capacity", capacity);
        return tag;
    }

    @Override
    public void onDestroy(Level level, BlockPos pos) {

    }

    @Override
    public PortStorage deepClone() {
        var res = new Ae2EnergyPortStorage(capacity);
        res.capacity = capacity;
        return res;
    }

    @Override
    public void reset() {
        this.capacity = 0;
        manualUpdate = true;
    }

}
