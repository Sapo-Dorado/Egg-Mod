package sapodorado.eggmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.ActionResult;
import sapodorado.eggmod.callback.EggBreakCallback;

public class EggMod implements ModInitializer {
	@Override
	public void onInitialize() {
        EggBreakCallback.EVENT.register((egg, hitResult) -> {
            if (!egg.world.isClient) {
                ChickenEntity chickenEntity = (ChickenEntity)EntityType.CHICKEN.create(egg.world);
                chickenEntity.refreshPositionAndAngles(egg.getX(), egg.getY(), egg.getZ(), egg.yaw, 0.0F);
                egg.world.spawnEntity(chickenEntity);
                egg.world.sendEntityStatus(egg, (byte)3);
                egg.remove();
            }
            return ActionResult.FAIL;
        });
	}
}