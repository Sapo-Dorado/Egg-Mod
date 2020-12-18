package net.sapodorado.eggmod.callback;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.HitResult;

/**
 * Callback for breaking an Egg
 * Called before random numbers would have determined if a chicken would spawn
 * Upon return:
 * - SUCCESS cancels further processing and continues with normal breaking behavior.
 * - PASS falls back to further processing and defaults to SUCCESS if no other listeners are available
 * - FAIL cancels further processing and does not spawn an entity.
**/

public interface EggBreakCallback {
    Event<EggBreakCallback> EVENT = EventFactory.createArrayBacked(EggBreakCallback.class,
        (listeners) -> (egg, hitResult) -> {
            for (EggBreakCallback listener: listeners) {
                ActionResult result = listener.collide(egg, hitResult);

                if(result != ActionResult.PASS) {
                    return result;
                }
            }
        return ActionResult.PASS;
        });

        ActionResult collide(EggEntity egg, HitResult hitResult);

}