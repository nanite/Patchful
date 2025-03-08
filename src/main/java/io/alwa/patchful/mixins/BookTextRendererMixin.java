package io.alwa.patchful.mixins;

import com.hrznstudio.emojiful.ClientEmojiHandler;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.patchouli.client.book.gui.BookTextRenderer;

@Mixin(BookTextRenderer.class)
public class BookTextRendererMixin {

    @Inject(method = "render(Lnet/minecraft/client/gui/GuiGraphics;IIF)V", at = @At(value = "INVOKE_ASSIGN", target = "Lvazkii/patchouli/common/book/Book;getFontStyle()Lnet/minecraft/network/chat/Style;"))
    void patchfulRender(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks, CallbackInfo ci, @Local Font font) {
        font = ClientEmojiHandler.oldFontRenderer == null ? font : ClientEmojiHandler.oldFontRenderer;
    }
}
