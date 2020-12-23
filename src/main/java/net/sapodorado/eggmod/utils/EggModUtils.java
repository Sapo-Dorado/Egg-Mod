package net.sapodorado.eggmod.utils;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.nbt.CompoundTag;

public class EggModUtils {
    private static final Random random = new Random();
    public static final EntityType<?>[] passive_entities = {
        EntityType.BAT,
        EntityType.BEE,
        EntityType.CAT,
        EntityType.CHICKEN,
        EntityType.COD,
        EntityType.COW,
        EntityType.DOLPHIN,
        EntityType.DONKEY,
        EntityType.FOX,
        EntityType.HORSE,
        EntityType.IRON_GOLEM,
        EntityType.LLAMA,
        EntityType.MULE,
        EntityType.MOOSHROOM,
        EntityType.OCELOT,
        EntityType.PANDA,
        EntityType.PARROT,
        EntityType.PIG,
        EntityType.POLAR_BEAR,
        EntityType.PUFFERFISH,
        EntityType.RABBIT,
        EntityType.SALMON,
        EntityType.SHEEP,
        EntityType.SKELETON_HORSE,
        EntityType.SNOW_GOLEM,
        EntityType.SQUID,
        EntityType.STRIDER,
        EntityType.TRADER_LLAMA,
        EntityType.TROPICAL_FISH,
        EntityType.TURTLE,
        EntityType.VILLAGER,
        EntityType.WANDERING_TRADER,
        EntityType.WOLF,
        EntityType.ZOMBIE_HORSE
    };

    public static final EntityType<?>[] hostile_entities = {
        EntityType.BLAZE,
        EntityType.CAVE_SPIDER,
        EntityType.CREEPER,
        EntityType.DROWNED,
        EntityType.ELDER_GUARDIAN,
        EntityType.ENDERMAN,
        EntityType.ENDERMITE,
        EntityType.EVOKER,
        EntityType.GHAST,
        EntityType.GUARDIAN,
        EntityType.HOGLIN,
        EntityType.HUSK,
        EntityType.ILLUSIONER,
        EntityType.MAGMA_CUBE,
        EntityType.PHANTOM,
        EntityType.PIGLIN,
        EntityType.PIGLIN_BRUTE,
        EntityType.PILLAGER,
        EntityType.RAVAGER,
        EntityType.SHULKER,
        EntityType.SILVERFISH,
        EntityType.SKELETON,
        EntityType.SLIME,
        EntityType.SPIDER,
        EntityType.STRAY,
        EntityType.VEX,
        EntityType.VINDICATOR,
        EntityType.WITCH,
        EntityType.WITHER_SKELETON,
        EntityType.ZOGLIN,
        EntityType.ZOMBIE,
        EntityType.ZOMBIE_VILLAGER,
        EntityType.ZOMBIFIED_PIGLIN
    };

    public static final EntityType<?>[] boss_entities = {
        EntityType.GIANT,
        EntityType.ENDER_DRAGON,
        EntityType.WITHER
    };

    public static void process_entity(Entity entity){
        EntityType<?> type = entity.getType();
        if(type.equals(EntityType.CAT)) {
            ((CatEntity)entity).setCatType(random.nextInt(10));
        } else if(type.equals(EntityType.SHEEP)) {
            ((SheepEntity)entity).setColor(SheepEntity.generateDefaultColor(new Random()));
        } else if(type.equals(EntityType.SLIME)){
            CompoundTag tag = new CompoundTag();
            tag.putInt("Size", 3);
            ((SlimeEntity)entity).readCustomDataFromTag(tag);
        } else if(type.equals(EntityType.MAGMA_CUBE)){
            CompoundTag tag = new CompoundTag();
            tag.putInt("Size", 3);
            ((MagmaCubeEntity)entity).readCustomDataFromTag(tag);
        }
    }

}
