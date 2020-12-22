package net.sapodorado.eggmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sapodorado.eggmod.entity.BossEggEntity;
import net.sapodorado.eggmod.entity.ChargedCreeperEggEntity;
import net.sapodorado.eggmod.entity.CreeperEggEntity;
import net.sapodorado.eggmod.entity.EasterEggEntity;
import net.sapodorado.eggmod.entity.HostileEggEntity;
import net.sapodorado.eggmod.entity.PassiveEggEntity;
import net.sapodorado.eggmod.entity.RandomEggEntity;
import net.sapodorado.eggmod.entity.TntEggEntity;
import net.sapodorado.eggmod.item.BossEggItem;
import net.sapodorado.eggmod.item.ChargedCreeperEggItem;
import net.sapodorado.eggmod.item.CreeperEggItem;
import net.sapodorado.eggmod.item.EasterEggItem;
import net.sapodorado.eggmod.item.HostileEggItem;
import net.sapodorado.eggmod.item.PassiveEggItem;
import net.sapodorado.eggmod.item.RandomEggItem;
import net.sapodorado.eggmod.item.TntEggItem;

public class EggMod implements ModInitializer {

    public static final String MODID = "eggmod";
    public static final Item RANDOM_EGG_ITEM = new RandomEggItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Item PASSIVE_EGG_ITEM = new PassiveEggItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Item HOSTILE_EGG_ITEM = new HostileEggItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Item BOSS_EGG_ITEM = new BossEggItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Item CREEPER_EGG_ITEM = new CreeperEggItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Item CHARGED_CREEPER_EGG_ITEM = new ChargedCreeperEggItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Item TNT_EGG_ITEM = new TntEggItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Item EASTER_EGG_ITEM = new EasterEggItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));

    public static final EntityType<RandomEggEntity> RANDOM_EGG_ENTITY = Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier(MODID, "random_egg_item"),
                    FabricEntityTypeBuilder.<RandomEggEntity>create(SpawnGroup.MISC, RandomEggEntity::new)
                                    .dimensions(EntityDimensions.fixed(0.25F,0.25F))
                                    .trackRangeBlocks(4).trackedUpdateRate(10)
                                    .build()
    );

    public static final EntityType<PassiveEggEntity> PASSIVE_EGG_ENTITY = Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier(MODID, "passive_egg_item"),
                    FabricEntityTypeBuilder.<PassiveEggEntity>create(SpawnGroup.MISC, PassiveEggEntity::new)
                                    .dimensions(EntityDimensions.fixed(0.25F,0.25F))
                                    .trackRangeBlocks(4).trackedUpdateRate(10)
                                    .build()
    );

    public static final EntityType<HostileEggEntity> HOSTILE_EGG_ENTITY = Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier(MODID, "hostile_egg_item"),
                    FabricEntityTypeBuilder.<HostileEggEntity>create(SpawnGroup.MISC, HostileEggEntity::new)
                                    .dimensions(EntityDimensions.fixed(0.25F,0.25F))
                                    .trackRangeBlocks(4).trackedUpdateRate(10)
                                    .build()
    );

    public static final EntityType<BossEggEntity> BOSS_EGG_ENTITY = Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier(MODID, "boss_egg_item"),
                    FabricEntityTypeBuilder.<BossEggEntity>create(SpawnGroup.MISC, BossEggEntity::new)
                                    .dimensions(EntityDimensions.fixed(0.25F,0.25F))
                                    .trackRangeBlocks(4).trackedUpdateRate(10)
                                    .build()
    );

    public static final EntityType<CreeperEggEntity> CREEPER_EGG_ENTITY = Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier(MODID, "creeper_egg_item"),
                    FabricEntityTypeBuilder.<CreeperEggEntity>create(SpawnGroup.MISC, CreeperEggEntity::new)
                                    .dimensions(EntityDimensions.fixed(0.25F,0.25F))
                                    .trackRangeBlocks(4).trackedUpdateRate(10)
                                    .build()
    );

    public static final EntityType<ChargedCreeperEggEntity> CHARGED_CREEPER_EGG_ENTITY = Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier(MODID, "charged_creeper_egg_item"),
                    FabricEntityTypeBuilder.<ChargedCreeperEggEntity>create(SpawnGroup.MISC, ChargedCreeperEggEntity::new)
                                    .dimensions(EntityDimensions.fixed(0.25F,0.25F))
                                    .trackRangeBlocks(4).trackedUpdateRate(10)
                                    .build()
    );

    public static final EntityType<TntEggEntity> TNT_EGG_ENTITY = Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier(MODID, "tnt_egg_item"),
                    FabricEntityTypeBuilder.<TntEggEntity>create(SpawnGroup.MISC, TntEggEntity::new)
                                    .dimensions(EntityDimensions.fixed(0.25F,0.25F))
                                    .trackRangeBlocks(4).trackedUpdateRate(10)
                                    .build()
    );

    public static final EntityType<EasterEggEntity> EASTER_EGG_ENTITY = Registry.register(
                    Registry.ENTITY_TYPE,
                    new Identifier(MODID, "easter_egg_item"),
                    FabricEntityTypeBuilder.<EasterEggEntity>create(SpawnGroup.MISC, EasterEggEntity::new)
                                    .dimensions(EntityDimensions.fixed(0.25F,0.25F))
                                    .trackRangeBlocks(4).trackedUpdateRate(10)
                                    .build()
    );

	@Override
	public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "random_egg_item"), RANDOM_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "passive_egg_item"), PASSIVE_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "hostile_egg_item"), HOSTILE_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "boss_egg_item"), BOSS_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "creeper_egg_item"), CREEPER_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "charged_creeper_egg_item"), CHARGED_CREEPER_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "tnt_egg_item"), TNT_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "easter_egg_item"), EASTER_EGG_ITEM);
    }

}