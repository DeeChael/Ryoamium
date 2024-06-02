package net.deechael.ryoamium.neoforge;


import net.deechael.ryoamium.Ryoamium;
import net.deechael.ryoamium.RyoamiumConstants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = RyoamiumConstants.MOD_ID, dist = Dist.CLIENT)
public class RyoamiumNeoForge {

    public RyoamiumNeoForge(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        RyoamiumConstants.LOG.info("Hello NeoForge world!");
        Ryoamium.init();

    }
}