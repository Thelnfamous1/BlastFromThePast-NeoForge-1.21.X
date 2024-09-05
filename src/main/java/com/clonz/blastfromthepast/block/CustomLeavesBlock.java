package com.clonz.blastfromthepast.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CustomLeavesBlock extends LeavesBlock {
    private final boolean isFlammable;
    private final int flammability;
    private final int fireSpreadSpeed;

    public CustomLeavesBlock(Properties properties, boolean isFlammable, int flammability, int fireSpreadSpeed) {
        super(properties);
        this.isFlammable = isFlammable;
        this.flammability = flammability;
        this.fireSpreadSpeed = fireSpreadSpeed;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return isFlammable;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return fireSpreadSpeed;
    }

}