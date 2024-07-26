package codyhuh.coralup.registry;

import codyhuh.coralup.CoralUp;
import codyhuh.coralup.common.blocks.BaseTallCoralBlock;
import codyhuh.coralup.common.blocks.TallCoralBlock;
import net.minecraft.world.level.block.BaseCoralPlantBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CoralPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CUBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CoralUp.MOD_ID);

    public static final RegistryObject<Block> DEAD_TALL_TUBE_CORAL = BLOCKS.register("dead_tall_tube_coral", () -> new BaseTallCoralBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_TUBE_CORAL)));
    public static final RegistryObject<Block> TALL_TUBE_CORAL = BLOCKS.register("tall_tube_coral", () -> new TallCoralBlock(CUBlocks.DEAD_TALL_TUBE_CORAL.get(), BlockBehaviour.Properties.copy(Blocks.TUBE_CORAL)));
    public static final RegistryObject<Block> DEAD_TALL_HORN_CORAL = BLOCKS.register("dead_tall_horn_coral", () -> new BaseTallCoralBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_HORN_CORAL)));
    public static final RegistryObject<Block> TALL_HORN_CORAL = BLOCKS.register("tall_horn_coral", () -> new TallCoralBlock(CUBlocks.DEAD_TALL_HORN_CORAL.get(), BlockBehaviour.Properties.copy(Blocks.HORN_CORAL)));
    public static final RegistryObject<Block> DEAD_TALL_BUBBLE_CORAL = BLOCKS.register("dead_tall_bubble_coral", () -> new BaseTallCoralBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUBBLE_CORAL)));
    public static final RegistryObject<Block> TALL_BUBBLE_CORAL = BLOCKS.register("tall_bubble_coral", () -> new TallCoralBlock(CUBlocks.DEAD_TALL_BUBBLE_CORAL.get(), BlockBehaviour.Properties.copy(Blocks.BUBBLE_CORAL)));
    public static final RegistryObject<Block> DEAD_TALL_FIRE_CORAL = BLOCKS.register("dead_tall_fire_coral", () -> new BaseTallCoralBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_FIRE_CORAL)));
    public static final RegistryObject<Block> TALL_FIRE_CORAL = BLOCKS.register("tall_fire_coral", () -> new TallCoralBlock(CUBlocks.DEAD_TALL_FIRE_CORAL.get(), BlockBehaviour.Properties.copy(Blocks.FIRE_CORAL)));
    public static final RegistryObject<Block> DEAD_TALL_BRAIN_CORAL = BLOCKS.register("dead_tall_brain_coral", () -> new BaseTallCoralBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BRAIN_CORAL)));
    public static final RegistryObject<Block> TALL_BRAIN_CORAL = BLOCKS.register("tall_brain_coral", () -> new TallCoralBlock(CUBlocks.DEAD_TALL_BRAIN_CORAL.get(), BlockBehaviour.Properties.copy(Blocks.BRAIN_CORAL)));

    public static final RegistryObject<Block> DEAD_BUSHY_TUBE_CORAL = BLOCKS.register("dead_bushy_tube_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_TUBE_CORAL)));
    public static final RegistryObject<Block> BUSHY_TUBE_CORAL = BLOCKS.register("bushy_tube_coral", () -> new CoralPlantBlock(CUBlocks.DEAD_BUSHY_TUBE_CORAL.get(), BlockBehaviour.Properties.copy(Blocks.TUBE_CORAL)));
    public static final RegistryObject<Block> DEAD_BUSHY_HORN_CORAL = BLOCKS.register("dead_bushy_horn_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_HORN_CORAL)));
    public static final RegistryObject<Block> BUSHY_HORN_CORAL = BLOCKS.register("bushy_horn_coral", () -> new CoralPlantBlock(CUBlocks.DEAD_BUSHY_HORN_CORAL.get(), BlockBehaviour.Properties.copy(Blocks.HORN_CORAL)));
    public static final RegistryObject<Block> DEAD_BUSHY_BUBBLE_CORAL = BLOCKS.register("dead_bushy_bubble_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUBBLE_CORAL)));
    public static final RegistryObject<Block> BUSHY_BUBBLE_CORAL = BLOCKS.register("bushy_bubble_coral", () -> new CoralPlantBlock(CUBlocks.DEAD_BUSHY_BUBBLE_CORAL.get(), BlockBehaviour.Properties.copy(Blocks.BUBBLE_CORAL)));
    public static final RegistryObject<Block> DEAD_BUSHY_FIRE_CORAL = BLOCKS.register("dead_bushy_fire_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_FIRE_CORAL)));
    public static final RegistryObject<Block> BUSHY_FIRE_CORAL = BLOCKS.register("bushy_fire_coral", () -> new CoralPlantBlock(CUBlocks.DEAD_BUSHY_FIRE_CORAL.get(), BlockBehaviour.Properties.copy(Blocks.FIRE_CORAL)));
    public static final RegistryObject<Block> DEAD_BUSHY_BRAIN_CORAL = BLOCKS.register("dead_bushy_brain_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BRAIN_CORAL)));
    public static final RegistryObject<Block> BUSHY_BRAIN_CORAL = BLOCKS.register("bushy_brain_coral", () -> new CoralPlantBlock(CUBlocks.DEAD_BUSHY_BRAIN_CORAL.get(), BlockBehaviour.Properties.copy(Blocks.BRAIN_CORAL)));

}
