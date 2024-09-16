package com.clonz.blastfromthepast.datagen.client;

import com.clonz.blastfromthepast.BlastFromThePast;
import com.clonz.blastfromthepast.block.BFTPStoneGroup;
import com.clonz.blastfromthepast.block.BFTPWoodGroup;
import com.clonz.blastfromthepast.init.ModBlocks;
import com.clonz.blastfromthepast.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelGen extends ItemModelProvider {

    public ModItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BlastFromThePast.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Items
        basicItem(ModItems.RAW_VENISON.get());
        basicItem(ModItems.SAP_BALL.get());
        basicItem(ModItems.COOKED_VENISON.get());
        withExistingParent(ModItems.SNOWDO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.GLACEROS_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.FROSTOMPER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        basicItem(ModItems.CEDAR_BOAT.get());
        basicItem(ModItems.CEDAR_CHEST_BOAT.get());

        basicItem(ModItems.PSYCHO_BERRY.get());
        basicItem(ModItems.SAP_ICE_CREAM.get());
        basicItem(ModItems.PSYCHO_BERRY_ICE_CREAM.get());
        basicItem(ModItems.MELON_ICE_CREAM.get());

        //Blocks
        registerWoodGroup(ModBlocks.CEDAR);
        registerStoneGroup(ModBlocks.PERMAFROST);
        createWithParent(ModBlocks.SAPPY_CEDAR_LOG);
        singleTextureDoublePlantBlock(ModBlocks.WHITE_DELPHINIUM, true);
        singleTextureDoublePlantBlock(ModBlocks.BLUE_DELPHINIUM, true);
        singleTextureDoublePlantBlock(ModBlocks.VIOLET_DELPHINIUM, true);
        singleTextureDoublePlantBlock(ModBlocks.PINK_DELPHINIUM, true);
    }

    private void registerStoneGroup(BFTPStoneGroup stoneGroup){
        createWithParent(stoneGroup.BLOCK);
        createWithParent(stoneGroup.STAIRS);
        createWithParent(stoneGroup.SLAB);
        withExistingParent(stoneGroup.WALL.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", modLoc("block/" + stoneGroup.WALL.getId().getPath().replaceAll("_wall", "")));

        createWithParent(stoneGroup.CHISELED_BRICKS);
        createWithParent(stoneGroup.BRICKS);
        createWithParent(stoneGroup.BRICKS_STAIRS);
        createWithParent(stoneGroup.BRICKS_SLAB);
        withExistingParent(stoneGroup.BRICKS_WALL.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", modLoc("block/" + stoneGroup.BRICKS_WALL.getId().getPath().replaceAll("_wall", "")));

        createWithParent(stoneGroup.POLISHED);
        createWithParent(stoneGroup.POLISHED_STAIRS);
        createWithParent(stoneGroup.POLISHED_SLAB);
        withExistingParent(stoneGroup.POLISHED_WALL.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", modLoc("block/" + stoneGroup.POLISHED_WALL.getId().getPath().replaceAll("_wall", "")));

        createWithParent(stoneGroup.COBBLESTONE);
        createWithParent(stoneGroup.COBBLESTONE_STAIRS);
        createWithParent(stoneGroup.COBBLESTONE_SLAB);
        withExistingParent(stoneGroup.COBBLESTONE_WALL.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", modLoc("block/" + stoneGroup.COBBLESTONE_WALL.getId().getPath().replaceAll("_wall", "")));

    }


    private void registerWoodGroup(BFTPWoodGroup woodGroup){
        createWithParent(woodGroup.BLOCK);
        createWithParent(woodGroup.LOG);
        createWithParent(woodGroup.STRIPPED_LOG);
        createWithParent(woodGroup.WOOD);
        createWithParent(woodGroup.STRIPPED_WOOD);
        createWithParent(woodGroup.SLAB);
        createWithParent(woodGroup.STAIRS);
        createWithParent(woodGroup.LEAVES);
        createSuffixedParent(woodGroup.FENCE, "_inventory");
        createWithParent(woodGroup.FENCE_GATE);
        createWithParent(woodGroup.PRESSURE_PLATE);
        createSuffixedParent(woodGroup.BUTTON, "_inventory");
        withExistingParent(woodGroup.TRAPDOOR.getId().getPath(),
                modLoc("block/" + woodGroup.BLOCK.getId().getPath() + "_trapdoor_bottom"));
        singleTextureBlock(woodGroup.DOOR);
        basicItem(woodGroup.SIGN_ITEM.get());
        basicItem(woodGroup.HANGING_SIGN_ITEM.get());
    }

    private void createWithParent(DeferredBlock<? extends Block> key) {
        withExistingParent(key.getId().getPath(), modLoc( "block/" + key.getId().getPath()));
    }

    private void singleTextureBlock(DeferredBlock<? extends Block> key){
        singleTexture(key.getId().getPath(), mcLoc("item/generated"), "layer0",
                modLoc("item/" + key.getId().getPath())).renderType("cutout_mipped");
    }

    private void createSuffixedParent(DeferredBlock<? extends Block> handler, String suffix) {
        withExistingParent(handler.getId().getPath(), modLoc( "block/" + handler.getId().getPath() + suffix));
    }

    private void singleTextureDoublePlantBlock(DeferredBlock<Block> block, boolean isTop){
        singleTexture((block.getId().getPath()),
                mcLoc("item/generated"),
                "layer0", modLoc("block/" + block.getId().getPath() + (isTop ? "_top" : "_bottom")));
    }
}


