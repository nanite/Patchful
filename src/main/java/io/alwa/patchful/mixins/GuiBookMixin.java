package io.alwa.patchful.mixins;

import io.alwa.patchful.Patchful;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.patchouli.client.book.gui.GuiBook;

@Mixin(Screen.class)
public class GuiBookMixin {

    @Mutable
    @Shadow @Final protected Font font;

    @Inject(method = "init(II)V", at = {@At("TAIL")})
    public void patchfulInit(int width, int height, CallbackInfo ci) {
        var screenClass = (Screen)(Object)this;
        if (screenClass instanceof GuiBook) {
            this.font = Patchful.patchfulFont;
        }
    }
}
