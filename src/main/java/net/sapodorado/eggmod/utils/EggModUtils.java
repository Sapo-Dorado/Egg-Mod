package net.sapodorado.eggmod.utils;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.HitResult;

public class EggModUtils {
    private static final Random random = new Random();
    private static final EntityType[] entities = {
        EntityType.BAT,
        EntityType.BEE,
        EntityType.BLAZE,
        EntityType.CAT,
        EntityType.CAVE_SPIDER,
        EntityType.CHICKEN,
        EntityType.COD,
        EntityType.COW,
        EntityType.CREEPER,
        EntityType.DOLPHIN,
        EntityType.DONKEY,
        EntityType.DROWNED,
        EntityType.ELDER_GUARDIAN,
        EntityType.ENDER_DRAGON,
        EntityType.ENDERMAN,
        EntityType.ENDERMITE,
        EntityType.EVOKER,
        EntityType.FOX,
        EntityType.GHAST,
        EntityType.GIANT,
        EntityType.GUARDIAN,
        EntityType.HOGLIN,
        EntityType.HORSE,
        EntityType.HUSK,
        EntityType.ILLUSIONER,
        EntityType.IRON_GOLEM,
        EntityType.LLAMA,
        EntityType.MAGMA_CUBE,
        EntityType.MULE,
        EntityType.MOOSHROOM,
        EntityType.OCELOT,
        EntityType.PANDA,
        EntityType.PARROT,
        EntityType.PHANTOM,
        EntityType.PIG,
        EntityType.PIGLIN,
        EntityType.PIGLIN_BRUTE,
        EntityType.PILLAGER,
        EntityType.POLAR_BEAR,
        EntityType.PUFFERFISH,
        EntityType.RABBIT,
        EntityType.RAVAGER,
        EntityType.SALMON,
        EntityType.SHEEP,
        EntityType.SHULKER,
        EntityType.SILVERFISH,
        EntityType.SKELETON,
        EntityType.SKELETON_HORSE,
        EntityType.SLIME,
        EntityType.SNOW_GOLEM,
        EntityType.SPIDER,
        EntityType.SQUID,
        EntityType.STRAY,
        EntityType.STRIDER,
        EntityType.TRADER_LLAMA,
        EntityType.TROPICAL_FISH,
        EntityType.TURTLE,
        EntityType.VEX,
        EntityType.VILLAGER,
        EntityType.VINDICATOR,
        EntityType.WANDERING_TRADER,
        EntityType.WITCH,
        EntityType.WITHER,
        EntityType.WITHER_SKELETON,
        EntityType.WOLF,
        EntityType.ZOGLIN,
        EntityType.ZOMBIE,
        EntityType.ZOMBIE_HORSE,
        EntityType.ZOMBIE_VILLAGER,
        EntityType.ZOMBIFIED_PIGLIN,
    };

    private static final int CAT_IDX = 3;
    private static final int SHEEP_IDX = 43;

    private EggModUtils() {
    }

    private static void updateEntity(Entity entity, int idx){
        switch(idx){
            case CAT_IDX:
                ((SheepEntity)entity).setColor(SheepEntity.generateDefaultColor(new Random()));
                break;
            case SHEEP_IDX:
                ((CatEntity)entity).setCatType(random.nextInt(10));
                break;
            default:
                break;
        }
    }

    public static ActionResult processCollision(EggEntity egg, HitResult hitResult){
        if (!egg.world.isClient) {
            int idx = random.nextInt(entities.length);
            Entity entity = entities[idx].create(egg.world);
            updateEntity(entity, idx);
            entity.refreshPositionAndAngles(egg.getX(), egg.getY(), egg.getZ(), egg.yaw, 0.0F);
            egg.world.spawnEntity(entity);
            egg.world.sendEntityStatus(egg, (byte)3);
            egg.remove();
        }
        return ActionResult.FAIL;
    }

}
