package codyhuh.coralup.common.level.features;

import codyhuh.coralup.common.blocks.TallCoralBlock;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class TallCoralFeature extends Feature<BlockStateConfiguration> {

    public TallCoralFeature(Codec<BlockStateConfiguration> config) {
        super(config);
    }

    public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
        boolean placed = false;
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        RandomSource rand = context.random();
        BlockState state = context.config().state;
        int i0 = rand.nextInt(8) - rand.nextInt(8);
        int i1 = rand.nextInt(8) - rand.nextInt(8);
        int heightMap = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX() + i0, pos.getZ() + i1);
        BlockPos newPos = new BlockPos(pos.getX() + i0, heightMap, pos.getZ() + i1);

        if (level.getBlockState(newPos).is(Blocks.WATER)) {
            if (state.canSurvive(level, newPos)) {
                    BlockState upperState = state.setValue(TallCoralBlock.HALF, DoubleBlockHalf.UPPER);
                    BlockPos abovePos = newPos.above();
                    if (level.getBlockState(abovePos).is(Blocks.WATER)) {
                        level.setBlock(newPos, state, 2);
                        level.setBlock(abovePos, upperState, 2);
                    }

                placed = true;
            }
        }

        return placed;
    }
}
