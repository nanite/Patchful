package io.alwa.patchful.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import io.alwa.patchful.Patchful;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.patchouli.client.book.gui.BookTextRenderer;

@Mixin(BookTextRenderer.class)
public class BookTextRendererMixin {

    @Inject(method = "extractRenderState(Lnet/minecraft/client/gui/GuiGraphicsExtractor;IIF)V", at = @At(value = "INVOKE_ASSIGN", target = "Lvazkii/patchouli/common/book/Book;getFontStyle()Lnet/minecraft/network/chat/Style;"))
    void patchfulRender(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks, CallbackInfo ci, @Local LocalRef<Font> font) {
        font.set(Patchful.patchfulFont);
    }
}
