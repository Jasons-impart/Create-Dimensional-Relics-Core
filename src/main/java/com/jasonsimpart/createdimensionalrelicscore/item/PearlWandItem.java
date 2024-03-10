package com.jasonsimpart.createdimensionalrelicscore.item;

import com.jasonsimpart.createdimensionalrelicscore.tab.CreativeTab;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

public class PearlWandItem extends Item {
    public PearlWandItem() {
        super(new Properties()
                .tab(CreativeTab.CREATE_DIMENSIONAL_RELICS_TAB)
                .fireResistant()
                .rarity(Rarity.EPIC));
        BlockEvent.CropGrowEvent
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        var player = context.getPlayer();
        var level = context.getLevel();
        if (level.isClientSide) {
            player.playSound(SoundEvents.ENDERMAN_TELEPORT, 2.0F, 1.0F);
        } else {
            var serverLevel = (ServerLevel) level;
            serverLevel.sendParticles(ParticleTypes.EXPLOSION, player.getX(), player.getY(0.5), player.getZ(),
                    1, 0.0, 0.0, 0.0, 0.0);
        }
        return InteractionResult.PASS;
    }
}
