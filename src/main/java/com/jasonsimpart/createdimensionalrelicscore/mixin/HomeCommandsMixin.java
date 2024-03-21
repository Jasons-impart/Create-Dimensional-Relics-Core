package com.jasonsimpart.createdimensionalrelicscore.mixin;

import dev.ftb.mods.ftbessentials.command.HomeCommands;
import dev.ftb.mods.ftbessentials.util.FTBEPlayerData;
import dev.ftb.mods.ftbessentials.util.TeleportPos;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HomeCommands.class)
public abstract class HomeCommandsMixin {
    @Inject(method = "home", at = @At("HEAD"), cancellable = true, remap = false)
    private static void home(ServerPlayer player, String name, CallbackInfoReturnable<Integer> cir) {
        if (player.isCreative())
            return;
        FTBEPlayerData data = FTBEPlayerData.get(player);
        if (data != null) {
            TeleportPos pos = (TeleportPos)data.homes.get(name.toLowerCase());
            if (pos != null) {
                if (!pos.dimension.location().equals(player.level.dimension().location()))
                    cir.setReturnValue(TeleportPos.TeleportResult.DIMENSION_NOT_FOUND.runCommand(player));
            }
        }
    }
}
