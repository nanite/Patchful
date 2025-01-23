package io.alwa.patchful.mixins;

import com.hrznstudio.emojiful.ClientEmojiHandler;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import vazkii.patchouli.client.book.gui.BookTextRenderer;

@Mixin(BookTextRenderer.class)
public class BookTextRendererMixin {

    @Inject(method = "render", at = @At(value = "INVOKE_ASSIGN", target = "Lvazkii/patchouli/common/book/Book;getFontStyle()Lnet/minecraft/network/chat/Style;"), locals = LocalCapture.CAPTURE_FAILHARD, remap = false)
    void patchfulRender(GuiGraphics graphics, int mouseX, int mouseY, CallbackInfo ci, Font font) {
        font = ClientEmojiHandler.oldFontRenderer;
    }
}
