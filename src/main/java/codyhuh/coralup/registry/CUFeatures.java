package codyhuh.coralup.registry;

import codyhuh.coralup.CoralUp;
import codyhuh.coralup.common.level.features.BushyCoralFeature;
import codyhuh.coralup.common.level.features.TallCoralFeature;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CUFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CoralUp.MOD_ID);

    public static final RegistryObject<Feature<BlockStateConfiguration>> TALL_BRAIN_CORAL = FEATURES.register("tall_brain_coral", () -> new TallCoralFeature(BlockStateConfiguration.CODEC));
    public static final RegistryObject<Feature<BlockStateConfiguration>> TALL_HORN_CORAL = FEATURES.register("tall_horn_coral", () -> new TallCoralFeature(BlockStateConfiguration.CODEC));
    public static final RegistryObject<Feature<BlockStateConfiguration>> TALL_FIRE_CORAL = FEATURES.register("tall_fire_coral", () -> new TallCoralFeature(BlockStateConfiguration.CODEC));
    public static final RegistryObject<Feature<BlockStateConfiguration>> TALL_BUBBLE_CORAL = FEATURES.register("tall_bubble_coral", () -> new TallCoralFeature(BlockStateConfiguration.CODEC));
    public static final RegistryObject<Feature<BlockStateConfiguration>> TALL_TUBE_CORAL = FEATURES.register("tall_tube_coral", () -> new TallCoralFeature(BlockStateConfiguration.CODEC));

    public static final RegistryObject<Feature<BlockStateConfiguration>> BUSHY_BRAIN_CORAL = FEATURES.register("bushy_brain_coral", () -> new BushyCoralFeature(BlockStateConfiguration.CODEC));
    public static final RegistryObject<Feature<BlockStateConfiguration>> BUSHY_HORN_CORAL = FEATURES.register("bushy_horn_coral", () -> new BushyCoralFeature(BlockStateConfiguration.CODEC));
    public static final RegistryObject<Feature<BlockStateConfiguration>> BUSHY_FIRE_CORAL = FEATURES.register("bushy_fire_coral", () -> new BushyCoralFeature(BlockStateConfiguration.CODEC));
    public static final RegistryObject<Feature<BlockStateConfiguration>> BUSHY_BUBBLE_CORAL = FEATURES.register("bushy_bubble_coral", () -> new BushyCoralFeature(BlockStateConfiguration.CODEC));
    public static final RegistryObject<Feature<BlockStateConfiguration>> BUSHY_TUBE_CORAL = FEATURES.register("bushy_tube_coral", () -> new BushyCoralFeature(BlockStateConfiguration.CODEC));
}