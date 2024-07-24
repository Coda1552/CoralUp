package codyhuh.coralup.registry;

import codyhuh.coralup.CoralUp;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CUItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CoralUp.MOD_ID);

    public static final RegistryObject<Item> TALL_TUBE_CORAL = ITEMS.register("tall_tube_coral", () -> new DoubleHighBlockItem(CUBlocks.TALL_TUBE_CORAL.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEAD_TALL_TUBE_CORAL = ITEMS.register("dead_tall_tube_coral", () -> new DoubleHighBlockItem(CUBlocks.DEAD_TALL_TUBE_CORAL.get(), new Item.Properties()));

    public static final RegistryObject<Item> TALL_HORN_CORAL = ITEMS.register("tall_horn_coral", () -> new DoubleHighBlockItem(CUBlocks.TALL_HORN_CORAL.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEAD_TALL_HORN_CORAL = ITEMS.register("dead_tall_horn_coral", () -> new DoubleHighBlockItem(CUBlocks.DEAD_TALL_HORN_CORAL.get(), new Item.Properties()));

    public static final RegistryObject<Item> TALL_BUBBLE_CORAL = ITEMS.register("tall_bubble_coral", () -> new DoubleHighBlockItem(CUBlocks.TALL_BUBBLE_CORAL.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEAD_TALL_BUBBLE_CORAL = ITEMS.register("dead_tall_bubble_coral", () -> new DoubleHighBlockItem(CUBlocks.DEAD_TALL_BUBBLE_CORAL.get(), new Item.Properties()));

    public static final RegistryObject<Item> TALL_FIRE_CORAL = ITEMS.register("tall_fire_coral", () -> new DoubleHighBlockItem(CUBlocks.TALL_FIRE_CORAL.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEAD_TALL_FIRE_CORAL = ITEMS.register("dead_tall_fire_coral", () -> new DoubleHighBlockItem(CUBlocks.DEAD_TALL_FIRE_CORAL.get(), new Item.Properties()));

    public static final RegistryObject<Item> TALL_BRAIN_CORAL = ITEMS.register("tall_brain_coral", () -> new DoubleHighBlockItem(CUBlocks.TALL_BRAIN_CORAL.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEAD_TALL_BRAIN_CORAL = ITEMS.register("dead_tall_brain_coral", () -> new DoubleHighBlockItem(CUBlocks.DEAD_TALL_BRAIN_CORAL.get(), new Item.Properties()));
}