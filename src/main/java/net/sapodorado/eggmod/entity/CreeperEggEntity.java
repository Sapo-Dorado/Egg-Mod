package net.sapodorado.eggmod.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.sapodorado.eggmod.EggMod;
import net.sapodorado.eggmod.utils.EggModUtils;

public class CreeperEggEntity extends ThrownItemEntity {
    public CreeperEggEntity(EntityType<? extends CreeperEggEntity> entityType, World world) {
        super(entityType, world);
    }

    public CreeperEggEntity(World world, LivingEntity owner) {
        super(EggMod.CREEPER_EGG_ENTITY, owner, world);
    }

    public CreeperEggEntity(World world, double x, double y, double z) {
        super(EggMod.CREEPER_EGG_ENTITY, x, y, z, world);
    }

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) {
        if (status == 3) {
            double d = 0.08D;

            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, this.getStack()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * d, ((double)this.random.nextFloat() - 0.5D) * d, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().damage(DamageSource.thrownProjectile(this, this.getOwner()), 0.0F);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            for (int i = 0; i < 4; i++){
                CreeperEntity entity = EntityType.CREEPER.create(this.world);
                EggModUtils.process_entity(entity);
                double x = this.getX();
                double z = this.getZ();
                if(i == 1) {
                    x += 1;
                } else if (i == 2){
                    z += 1;
                } else if (i == 3) {
                    x += 1;
                    z += 1;
                }
                entity.refreshPositionAndAngles(x, this.getY(), z, this.yaw, 0.0F);
                this.world.spawnEntity(entity);
            }

            this.world.sendEntityStatus(this, (byte)3);
            this.remove();
        }

    }

    @Override
    protected Item getDefaultItem() {
        return EggMod.CREEPER_EGG_ITEM;
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacket.create(this, EggMod.PacketID);
    }
}