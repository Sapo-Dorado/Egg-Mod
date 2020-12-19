package net.sapodorado.eggmod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.sapodorado.eggmod.entity.RandomEggEntity;

public class RandomEggItem extends EggItem {
    public RandomEggItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (RANDOM.nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
           RandomEggEntity randomEggEntity = new RandomEggEntity(world, user);
           randomEggEntity.setItem(itemStack);
           randomEggEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 1.0F);
           world.spawnEntity(randomEggEntity);
        }
  
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.abilities.creativeMode) {
           itemStack.decrement(1);
        }
  
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
