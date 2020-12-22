package net.sapodorado.eggmod.utils;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.sapodorado.eggmod.EggMod;

public class VeryLuckyEggUtils {
    private static final Random random = new Random();
    public static void processCollision(Entity entity){
        int i = random.nextInt(5);
        ItemStack stack;
        ItemEntity itemEntity;
        if(i == 0){
            stack = new ItemStack(Items.BLUE_ICE, 64);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        } else if (i == 1) {
            stack = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        } else if (i == 2) {
            stack = new ItemStack(Items.SHULKER_SHELL, 8);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        } else if (i == 3) {
            stack = new ItemStack(Items.NETHERITE_INGOT, 1);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        } else{
            stack = new ItemStack(Items.DRAGON_BREATH, 1);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        }
        EggModUtils.process_entity(itemEntity);
        entity.world.spawnEntity(itemEntity);

        if(random.nextInt(10) == 0){
            stack = new ItemStack(EggMod.VERY_LUCKY_EGG_ITEM, 1);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
            EggModUtils.process_entity(itemEntity);
            entity.world.spawnEntity(itemEntity);
        }
    }
}
