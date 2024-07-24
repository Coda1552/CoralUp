package codyhuh.coralup;

import codyhuh.coralup.registry.CUBlocks;
import codyhuh.coralup.registry.CUItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CoralUp.MOD_ID)
public class CoralUp {
    public static final String MOD_ID = "coralup";

    public CoralUp() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        CUBlocks.BLOCKS.register(bus);
        CUItems.ITEMS.register(bus);

        bus.addListener(this::populateTabs);
    }

    private void populateTabs(BuildCreativeModeTabContentsEvent e) {
        if (e.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            for (var items : CUItems.ITEMS.getEntries()) {
                e.accept(items);
            }
        }
    }
}
