package net.sapodorado.eggmod.utils;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.sapodorado.eggmod.EggMod;

public class UnluckyEggUtils {
    private static final Random random = new Random();
    public static void processCollision(Entity e){
        int i = random.nextInt(8);
        ItemStack stack;
        Entity entity;
        if(i == 0){
            stack = new ItemStack(Items.COCOA_BEANS, 1);
            entity = new ItemEntity(e.world, e.getX(), e.getY(), e.getZ(), stack);
        } else if (i == 1) {
            stack = new ItemStack(Items.ROTTEN_FLESH, 1);
            entity = new ItemEntity(e.world, e.getX(), e.getY(), e.getZ(), stack);
        } else if (i == 2) {
            stack = new ItemStack(Items.ICE, 1);
            entity = new ItemEntity(e.world, e.getX(), e.getY(), e.getZ(), stack);
        } else if (i == 3) {
            stack = new ItemStack(Items.MELON_SEEDS, 1);
            entity = new ItemEntity(e.world, e.getX(), e.getY(), e.getZ(), stack);
        } else if (i == 4){
            stack = new ItemStack(Items.PUMPKIN_SEEDS, 1);
            entity = new ItemEntity(e.world, e.getX(), e.getY(), e.getZ(), stack);
        } else if (i == 5) {
            stack = new ItemStack(Items.KELP, 1);
            entity = new ItemEntity(e.world, e.getX(), e.getY(), e.getZ(), stack);
        } else if (i == 6){
            stack = new ItemStack(Items.INK_SAC, 1);
            entity = new ItemEntity(e.world, e.getX(), e.getY(), e.getZ(), stack);
        } else {
            entity = EntityType.BAT.create(e.world);
            entity.refreshPositionAndAngles(e.getX(), e.getY(), e.getZ(), e.yaw, 0.0F);
        }
        EggModUtils.process_entity(entity);
        entity.world.spawnEntity(entity);

        if(random.nextInt(10) == 0){
            stack = new ItemStack(EggMod.UNLUCKY_EGG_ITEM, 1);
            entity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
            EggModUtils.process_entity(entity);
            entity.world.spawnEntity(entity);
        }
    }
    
}
