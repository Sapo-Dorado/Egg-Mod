package net.sapodorado.eggmod.item;

import java.util.List;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.sapodorado.eggmod.entity.MildlyLuckyEggEntity;

public class MildlyLuckyEggItem extends EggItem {
    public MildlyLuckyEggItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (RANDOM.nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
           MildlyLuckyEggEntity mildlyLuckyEggEntity = new MildlyLuckyEggEntity(world, user);
           mildlyLuckyEggEntity.setItem(itemStack);
           mildlyLuckyEggEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 1.0F);
           world.spawnEntity(mildlyLuckyEggEntity);
        }
  
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.abilities.creativeMode) {
           itemStack.decrement(1);
        }
  
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.eggmod.mildly_lucky_egg_item.tooltip"));
    }
}