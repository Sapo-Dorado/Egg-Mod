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
import net.sapodorado.eggmod.entity.PassiveEggEntity;
import net.sapodorado.eggmod.entity.RandomEggEntity;
import net.sapodorado.eggmod.item.PassiveEggItem;
import net.sapodorado.eggmod.item.RandomEggItem;

public class EggMod implements ModInitializer {

    public static final String MODID = "eggmod";
    public static final Item RANDOM_EGG_ITEM = new RandomEggItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Item PASSIVE_EGG_ITEM = new PassiveEggItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));

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

	@Override
	public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "random_egg_item"), RANDOM_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "passive_egg_item"), PASSIVE_EGG_ITEM);
    }

}