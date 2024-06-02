package net.deechael.ryoamium.neoforge;

import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;
import net.deechael.ryoamium.RyoamiumConstants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.embeddedt.embeddium.api.OptionGUIConstructionEvent;

import java.util.List;

@EventBusSubscriber(modid = RyoamiumConstants.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.GAME)
public class RyoamiumOptions {

    public static final OptionStorage<?> STORAGE = new RyoamiumOptionsStorage();

    @SubscribeEvent
    public static void event(OptionGUIConstructionEvent event) {
        List<OptionPage> pages = event.getPages();
        pages.add(new RyoamiumOptionPage());
    }

}
