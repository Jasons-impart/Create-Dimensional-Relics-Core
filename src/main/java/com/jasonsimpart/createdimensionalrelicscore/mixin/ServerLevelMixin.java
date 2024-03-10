package com.jasonsimpart.createdimensionalrelicscore.mixin;

import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {
    @Shadow public abstract void setDayTime(long p_8616_);

    @Inject(method = "tickTime", at = @At(value = "RETURN"))
    public void setNight(CallbackInfo ci) {
        setDayTime(18000);
    }
}
