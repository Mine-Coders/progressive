package minecoders.progressive.client.integration;

import minecoders.progressive.client.screens.integration.NoMidnightLib;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import eu.midnightdust.lib.config.MidnightConfig;
import minecoders.progressive.Progressive;
import net.fabricmc.loader.api.FabricLoader;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            if (FabricLoader.getInstance().isModLoaded("midnightlib"))
                return MidnightConfig.getScreen(parent, Progressive.MOD_ID);

            return new NoMidnightLib(parent);
        };
    }
}
