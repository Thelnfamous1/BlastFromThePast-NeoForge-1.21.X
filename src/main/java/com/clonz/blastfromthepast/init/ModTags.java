package com.clonz.blastfromthepast.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items{
        public static final TagKey<Item> FROSTOMPER_FOOD = TagKey.create(Registries.ITEM, ModEntities.FROSTOMPER.getId().withSuffix("_food"));
        public static final TagKey<Item> FROSTOMPER_TEMPT_ITEMS = TagKey.create(Registries.ITEM, ModEntities.FROSTOMPER.getId().withSuffix("_tempt_items"));
    }
    public static class Blocks{
        public static final TagKey<Block> FROSTOMPER_CAN_BREAK = TagKey.create(Registries.BLOCK, ModEntities.FROSTOMPER.getId().withSuffix("_can_break"));
    }
}
