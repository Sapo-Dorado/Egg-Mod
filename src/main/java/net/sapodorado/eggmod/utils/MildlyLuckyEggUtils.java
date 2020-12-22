package net.sapodorado.eggmod.utils;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.sapodorado.eggmod.EggMod;

public class MildlyLuckyEggUtils {
    
    private static final Random random = new Random();
    public static void processCollision(Entity entity){
        int i = random.nextInt(7);
        ItemStack stack;
        ItemEntity itemEntity;
        if(i == 0){
            stack = new ItemStack(Items.PACKED_ICE, 16);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        } else if (i == 1) {
            stack = new ItemStack(Items.NETHER_WART, 4);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        } else if (i == 2) {
            stack = new ItemStack(Items.NAME_TAG, 1);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        } else if (i == 3) {
            stack = new ItemStack(Items.GOLDEN_CARROT, 5);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        } else if(i == 4){
            stack = new ItemStack(Items.PRISMARINE_CRYSTALS, 5);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        } else if (i == 5) {
            stack = new ItemStack(Items.PRISMARINE_SHARD, 4);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        }else{
            stack = new ItemStack(Items.SLIME_BALL, 5);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
        }
        EggModUtils.process_entity(itemEntity);
        entity.world.spawnEntity(itemEntity);

        if(random.nextInt(10) == 0){
            stack = new ItemStack(EggMod.MILDLY_LUCKY_EGG_ITEM, 1);
            itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), stack);
            EggModUtils.process_entity(itemEntity);
            entity.world.spawnEntity(itemEntity);
        }
    }
    
}