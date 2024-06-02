package net.deechael.ryoamium.neoforge;


import net.deechael.ryoamium.Ryoamium;
import net.deechael.ryoamium.RyoamiumConstants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = RyoamiumConstants.MOD_ID, dist = Dist.CLIENT)
public class RyoamiumNeoForge {

    public RyoamiumNeoForge(IEventBus eventBus) {
        Ryoamium.init();
    }

}