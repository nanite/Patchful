package io.alwa.patchful;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Patchful.MODID)
public class Patchful {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "patchful";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public Patchful() {
        LOGGER.info("Patchful Mod Loaded");
    }

}
