package net.deechael.ryoamium.fabric;

import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;
import org.embeddedt.embeddium.api.OptionGUIConstructionEvent;

import java.util.List;

public class RyoamiumOptions {

    public static final OptionStorage<?> STORAGE = new RyoamiumOptionsStorage();

    public static void init() {
        OptionGUIConstructionEvent.BUS.addListener(event -> {
            List<OptionPage> pages = event.getPages();
            pages.add(new RyoamiumOptionPage());
        });
    }

}
