package net.sapodorado.eggmod;

import net.fabricmc.api.ModInitializer;
import net.sapodorado.eggmod.callback.EggBreakCallback;
import net.sapodorado.eggmod.utils.EggModUtils;

public class EggMod implements ModInitializer {
	@Override
	public void onInitialize() {
        EggBreakCallback.EVENT.register(EggModUtils::processCollision);
    }
}