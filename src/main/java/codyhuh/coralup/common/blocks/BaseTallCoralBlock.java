package codyhuh.coralup.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseCoralPlantBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CoralPlantBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;

public class BaseTallCoralBlock extends BaseCoralPlantBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public BaseTallCoralBlock(Properties p_52861_) {
        super(p_52861_);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }

    public BlockState updateShape(BlockState p_52894_, Direction p_52895_, BlockState p_52896_, LevelAccessor p_52897_, BlockPos p_52898_, BlockPos p_52899_) {
        DoubleBlockHalf doubleblockhalf = p_52894_.getValue(HALF);
        if (p_52895_.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (p_52895_ == Direction.UP) || p_52896_.is(this) && p_52896_.getValue(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && p_52895_ == Direction.DOWN && !p_52894_.canSurvive(p_52897_, p_52898_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_52894_, p_52895_, p_52896_, p_52897_, p_52898_, p_52899_);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_49163_) {
        FluidState fluidstate = p_49163_.getLevel().getFluidState(p_49163_.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8));
    }

    public void setPlacedBy(Level p_52872_, BlockPos p_52873_, BlockState p_52874_, LivingEntity p_52875_, ItemStack p_52876_) {
        BlockPos blockpos = p_52873_.above();
        p_52872_.setBlock(blockpos, copyWaterloggedFrom(p_52872_, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)), 3);
    }

    public boolean canSurvive(BlockState p_52887_, LevelReader p_52888_, BlockPos p_52889_) {
        if (p_52887_.getValue(HALF) != DoubleBlockHalf.UPPER) {
            return super.canSurvive(p_52887_, p_52888_, p_52889_);
        } else {
            BlockState blockstate = p_52888_.getBlockState(p_52889_.below());
            if (p_52887_.getBlock() != this) return super.canSurvive(p_52887_, p_52888_, p_52889_);
            return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public static BlockState copyWaterloggedFrom(LevelReader p_182454_, BlockPos p_182455_, BlockState p_182456_) {
        return p_182456_.hasProperty(BlockStateProperties.WATERLOGGED) ? p_182456_.setValue(BlockStateProperties.WATERLOGGED, p_182454_.isWaterAt(p_182455_)) : p_182456_;
    }

    public void playerWillDestroy(Level p_52878_, BlockPos p_52879_, BlockState p_52880_, Player p_52881_) {
        if (!p_52878_.isClientSide) {
            if (p_52881_.isCreative()) {
                preventCreativeDropFromBottomPart(p_52878_, p_52879_, p_52880_, p_52881_);
            } else {
                dropResources(p_52880_, p_52878_, p_52879_, null, p_52881_, p_52881_.getMainHandItem());
            }
        }

        super.playerWillDestroy(p_52878_, p_52879_, p_52880_, p_52881_);
    }

    public void playerDestroy(Level p_52865_, Player p_52866_, BlockPos p_52867_, BlockState p_52868_, @Nullable BlockEntity p_52869_, ItemStack p_52870_) {
        super.playerDestroy(p_52865_, p_52866_, p_52867_, Blocks.AIR.defaultBlockState(), p_52869_, p_52870_);
    }

    protected static void preventCreativeDropFromBottomPart(Level p_52904_, BlockPos p_52905_, BlockState p_52906_, Player p_52907_) {
        DoubleBlockHalf doubleblockhalf = p_52906_.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = p_52905_.below();
            BlockState blockstate = p_52904_.getBlockState(blockpos);
            if (blockstate.is(p_52906_.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                p_52904_.setBlock(blockpos, blockstate1, 35);
                p_52904_.levelEvent(p_52907_, 2001, blockpos, Block.getId(blockstate));
            }
        }
    }

    public FluidState getFluidState(BlockState p_49191_) {
        return p_49191_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_49191_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52901_) {
        p_52901_.add(HALF).add(WATERLOGGED);
    }

    public long getSeed(BlockState p_52891_, BlockPos p_52892_) {
        return Mth.getSeed(p_52892_.getX(), p_52892_.below(p_52891_.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), p_52892_.getZ());
    }
}
