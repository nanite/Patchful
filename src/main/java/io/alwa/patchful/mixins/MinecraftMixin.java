package io.alwa.patchful.mixins;

import io.alwa.patchful.Patchful;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Minecraft.class, priority = 1)
public abstract class MinecraftMixin {
    @Inject(method = "<init>*", at = @At(value = "RETURN"))
    private void initFont(CallbackInfo callbackInfo) {
        Patchful.setup();
    }
}
