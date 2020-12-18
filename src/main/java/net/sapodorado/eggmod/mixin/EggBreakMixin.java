package net.sapodorado.eggmod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.HitResult;
import net.sapodorado.eggmod.callback.EggBreakCallback;

@Mixin(EggEntity.class) 
public class EggBreakMixin{
	@Inject(at = @At(value="INVOKE", target="java.util.Random.nextInt(I)I"), method="onCollision(Lnet/minecraft/util/hit/HitResult;)V", cancellable = true)
	private void collision(final HitResult hitResult, final CallbackInfo info) {
		ActionResult result = EggBreakCallback.EVENT.invoker().collide((EggEntity) (Object) this, hitResult);

		if(result == ActionResult.FAIL) {
			info.cancel();
		}
	}
}