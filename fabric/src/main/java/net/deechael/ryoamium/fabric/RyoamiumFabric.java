package net.deechael.ryoamium.fabric;

import net.deechael.ryoamium.Ryoamium;
import net.fabricmc.api.ClientModInitializer;

public class RyoamiumFabric implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        Ryoamium.init();
        RyoamiumOptions.init();
    }

}
