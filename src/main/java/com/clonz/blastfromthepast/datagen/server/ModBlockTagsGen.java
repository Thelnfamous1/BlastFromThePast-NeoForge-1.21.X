package com.clonz.blastfromthepast.datagen.server;

import com.clonz.blastfromthepast.BlastFromThePast;
import com.clonz.blastfromthepast.block.BFTPWoodGroup;
import com.clonz.blastfromthepast.init.ModBlocks;
import com.clonz.blastfromthepast.init.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsGen extends BlockTagsProvider {
    public ModBlockTagsGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BlastFromThePast.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.SAPPY_CEDAR_LOG.get());
        tag(ModTags.Blocks.FROSTOMPER_CAN_BREAK)
                .addTag(BlockTags.LEAVES);

        loadWoodGroupBlockTags(ModBlocks.CEDAR);

        tag(BlockTags.TALL_FLOWERS)
                .add(ModBlocks.WHITE_DELPHINIUM.get())
                .add(ModBlocks.BLUE_DELPHINIUM.get())
                .add(ModBlocks.PINK_DELPHINIUM.get())
                .add(ModBlocks.VIOLET_DELPHINIUM.get());
    }

    private void loadWoodGroupBlockTags(BFTPWoodGroup woodGroup){
        tag(BlockTags.LOGS_THAT_BURN)
                .add(woodGroup.LOG.get())
                .add(woodGroup.STRIPPED_LOG.get())
                .add(woodGroup.WOOD.get())
                .add(woodGroup.STRIPPED_WOOD.get());
        tag(BlockTags.PLANKS)
                .add(woodGroup.BLOCK.get());
        tag(BlockTags.LEAVES)
                .add(woodGroup.LEAVES.get());
        tag(BlockTags.STAIRS)
                .add(woodGroup.STAIRS.get());
        tag(BlockTags.WOODEN_FENCES)
                .add(woodGroup.FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(woodGroup.FENCE_GATE.get());
        tag(BlockTags.STANDING_SIGNS)
                .add(woodGroup.SIGN.get());
        tag(BlockTags.WALL_SIGNS)
                .add(woodGroup.WALL_SIGN.get());
        tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(woodGroup.HANGING_SIGN.get());
        tag(BlockTags.WALL_HANGING_SIGNS)
                .add(woodGroup.HANGING_SIGN_WALL.get());
        tag(BlockTags.WOODEN_DOORS)
                .add(woodGroup.DOOR.get());
        tag(BlockTags.WOODEN_BUTTONS)
                .add(woodGroup.BUTTON.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(woodGroup.PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_SLABS)
                .add(woodGroup.SLAB.get());
        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(woodGroup.TRAPDOOR.get());
        tag(BlockTags.WOODEN_STAIRS)
                .add(woodGroup.STAIRS.get());
    }
}
