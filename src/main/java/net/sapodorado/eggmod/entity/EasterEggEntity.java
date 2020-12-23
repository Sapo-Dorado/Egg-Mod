package net.sapodorado.eggmod.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.sapodorado.eggmod.EggMod;
import net.sapodorado.eggmod.client.EggModClient;
import net.sapodorado.eggmod.utils.EggModUtils;

public class EasterEggEntity extends ThrownItemEntity {
    public EasterEggEntity(EntityType<? extends EasterEggEntity> entityType, World world) {
        super(entityType, world);
    }

    public EasterEggEntity(World world, LivingEntity owner) {
        super(EggMod.EASTER_EGG_ENTITY, owner, world);
    }

    public EasterEggEntity(World world, double x, double y, double z) {
        super(EggMod.EASTER_EGG_ENTITY, x, y, z, world);
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
            if(random.nextInt(2) == 0){
                for (int i = 0; i < 64; i++) {
                    WitherEntity wither = EntityType.WITHER.create(this.world);
                    wither.refreshPositionAndAngles(this.getX() + random.nextInt(5), this.getY(), this.getZ() + random.nextInt(5), this.yaw, 0.0F);
                    EggModUtils.process_entity(wither);
                    this.world.spawnEntity(wither);
                }
            } else {
                ItemStack stack = new ItemStack(Items.DIAMOND_BLOCK, 64);
                ItemEntity itemEntity = new ItemEntity(this.world, this.getX(), this.getY(), this.getZ(), stack);
                EggModUtils.process_entity(itemEntity);
                this.world.spawnEntity(itemEntity);
            }

            this.world.sendEntityStatus(this, (byte)3);
            this.remove();
        }

    }

    @Override
    protected Item getDefaultItem() {
        return EggMod.EASTER_EGG_ITEM;
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacket.create(this, EggMod.PacketID);
    }
}