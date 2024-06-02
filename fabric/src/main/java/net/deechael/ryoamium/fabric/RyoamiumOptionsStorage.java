package net.deechael.ryoamium.fabric;

import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;
import org.thinkingstudio.ryoamiclights.RyoamicLights;

public class RyoamiumOptionsStorage implements OptionStorage<Object> {

    @Override
    public Object getData() {
        return new Object();
    }

    @Override
    public void save() {
        RyoamicLights.get().config.save();
    }

}
