package net.sapodorado.eggmod.client;

import net.sapodorado.eggmod.EggMod;
import net.sapodorado.eggmod.entity.EntitySpawnPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

public class EggModClient implements ClientModInitializer {
	public static final Identifier PacketID = new Identifier(EggMod.MODID, "spawn_packet");

	private static final EntityType<?> entities[] = {
		EggMod.RANDOM_EGG_ENTITY,
		EggMod.PASSIVE_EGG_ENTITY,
		EggMod.HOSTILE_EGG_ENTITY,
		EggMod.BOSS_EGG_ENTITY,
		EggMod.CREEPER_EGG_ENTITY,
		EggMod.CHARGED_CREEPER_EGG_ENTITY,
		EggMod.TNT_EGG_ENTITY,
		EggMod.EASTER_EGG_ENTITY,
		EggMod.ASSASSIN_EGG_ENTITY,
		EggMod.UNLUCKY_EGG_ENTITY,
		EggMod.MILDLY_LUCKY_EGG_ENTITY,
		EggMod.VERY_LUCKY_EGG_ENTITY
	};
	@Override
	public void onInitializeClient() {
		for(EntityType<?> e: entities) {
			EntityRendererRegistry.INSTANCE.register(e, (dispatcher, context) ->
					new FlyingItemEntityRenderer<>(dispatcher, context.getItemRenderer()));
		}
		receiveEntityPacket();
	}

	public void receiveEntityPacket() {
		ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> {
			EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
			UUID uuid = byteBuf.readUuid();
			int entityId = byteBuf.readVarInt();
			Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
			float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
			float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
			ctx.getTaskQueue().execute(() -> {
				if (MinecraftClient.getInstance().world == null)
					throw new IllegalStateException("Tried to spawn entity in a null world!");
				Entity e = et.create(MinecraftClient.getInstance().world);
				if (e == null)
					throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
				e.updateTrackedPosition(pos);
				e.setPos(pos.x, pos.y, pos.z);
				e.pitch = pitch;
				e.yaw = yaw;
				e.setEntityId(entityId);
				e.setUuid(uuid);
				MinecraftClient.getInstance().world.addEntity(entityId, e);
			});
		});
	}
}
