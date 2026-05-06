package codyhuh.coralup.common;

import codyhuh.coralup.CoralUp;
import codyhuh.coralup.common.blocks.TallCoralBlock;
import codyhuh.coralup.registry.CUBlocks;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = CoralUp.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {

    public static Map<Block, Block> coralMap = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(Blocks.BRAIN_CORAL, CUBlocks.TALL_BRAIN_CORAL.get());
        hashMap.put(Blocks.FIRE_CORAL, CUBlocks.TALL_FIRE_CORAL.get());
        hashMap.put(Blocks.BUBBLE_CORAL, CUBlocks.TALL_BUBBLE_CORAL.get());
        hashMap.put(Blocks.HORN_CORAL, CUBlocks.TALL_HORN_CORAL.get());
        hashMap.put(Blocks.TUBE_CORAL, CUBlocks.TALL_TUBE_CORAL.get());
    });

    public static Map<Block, Block> bushyCoralMap = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(Blocks.BRAIN_CORAL_FAN, CUBlocks.BUSHY_BRAIN_CORAL.get());
        hashMap.put(Blocks.FIRE_CORAL_FAN, CUBlocks.BUSHY_FIRE_CORAL.get());
        hashMap.put(Blocks.BUBBLE_CORAL_FAN, CUBlocks.BUSHY_BUBBLE_CORAL.get());
        hashMap.put(Blocks.HORN_CORAL_FAN, CUBlocks.BUSHY_HORN_CORAL.get());
        hashMap.put(Blocks.TUBE_CORAL_FAN, CUBlocks.BUSHY_TUBE_CORAL.get());
    });
    
    @SubscribeEvent
    public static void interactCoral(PlayerInteractEvent.RightClickBlock e) {
        Player player = e.getEntity();
        ItemStack stack = player.getItemInHand(e.getHand());
        if (!(stack.getItem() instanceof BoneMealItem)) return;
        
        Level level = e.getLevel();
        BlockPos pos = e.getHitVec().getBlockPos();
        BlockState state = level.getBlockState(pos);
        if (!level.getBlockState(pos.above()).canBeReplaced()) return;
        if (!coralMap.containsKey(state.getBlock()) && !bushyCoralMap.containsKey(state.getBlock())) return;
        
        BoneMealItem.addGrowthParticles(level, pos, 15);
        level.playLocalSound(pos, SoundEvents.BONE_MEAL_USE, SoundSource.PLAYERS, 1.0F, 1.0F, true);
        player.swing(e.getHand());
        
        if (coralMap.containsKey(state.getBlock())) {
            BlockState newState = coralMap.get(state.getBlock()).defaultBlockState();
            level.setBlock(pos, newState.setValue(TallCoralBlock.HALF, DoubleBlockHalf.LOWER), -1);
            level.setBlock(pos.above(), newState.setValue(TallCoralBlock.HALF, DoubleBlockHalf.UPPER), -1);
        } else if (bushyCoralMap.containsKey(state.getBlock())) {
            BlockState newState = bushyCoralMap.get(state.getBlock()).defaultBlockState();
            level.setBlock(pos, newState, -1);
        }
        
        if (!player.isCreative()) {
            stack.shrink(1);
        }
    }
}
