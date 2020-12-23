package net.sapodorado.eggmod.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.sapodorado.eggmod.EggMod;

public class AssassinEggEntity extends ThrownItemEntity {
    public AssassinEggEntity(EntityType<? extends AssassinEggEntity> entityType, World world) {
        super(entityType, world);
    }

    public AssassinEggEntity(World world, LivingEntity owner) {
        super(EggMod.ASSASSIN_EGG_ENTITY, owner, world);
    }

    public AssassinEggEntity(World world, double x, double y, double z) {
        super(EggMod.ASSASSIN_EGG_ENTITY, x, y, z, world);
    }

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) {
        if (status == 3) {
            double d = 0.08D;

            for (int i = 0; i < 8; ++i) {
                this.world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, this.getStack()), this.getX(),
                        this.getY(), this.getZ(), ((double) this.random.nextFloat() - 0.5D) * d,
                        ((double) this.random.nextFloat() - 0.5D) * d,
                        ((double) this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        PlayerEntity player = (PlayerEntity)this.getOwner();
        entityHitResult.getEntity().damage(DamageSource.thrownProjectile(this, player), 1000.0F);
        if(player != null && !player.abilities.creativeMode){
            ItemStack stack = new ItemStack(EggMod.ASSASSIN_EGG_ITEM, 1);
            player.giveItemStack(stack);
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            if(hitResult.getType() != HitResult.Type.ENTITY){
                PlayerEntity player = (PlayerEntity)this.getOwner();
                if(player != null) {
                    player.damage(DamageSource.thrownProjectile(this, player), 1000.0F);
                }
            }
            this.world.sendEntityStatus(this, (byte)3);
            this.remove();
        }

    }

    @Override
    protected Item getDefaultItem() {
        return EggMod.ASSASSIN_EGG_ITEM;
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacket.create(this, EggMod.PacketID);
    }
}
