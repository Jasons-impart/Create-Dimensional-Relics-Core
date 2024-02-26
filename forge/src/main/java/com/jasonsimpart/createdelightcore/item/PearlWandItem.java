package com.jasonsimpart.createdelightcore.item;

import com.jasonsimpart.createdelightcore.tab.CreativeTab;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

public class PearlWandItem extends Item {
    public PearlWandItem() {
        super(new Properties().tab(CreativeTab.DELIGHT_TAB).fireResistant());
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
