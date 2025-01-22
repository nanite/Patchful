package io.alwa.patchful.mixins;

import com.hrznstudio.emojiful.ClientEmojiHandler;
import net.minecraft.client.gui.Font;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import vazkii.patchouli.client.book.text.TextLayouter;

@Mixin(TextLayouter.class)
public class TextLayouterMixin {

    @ModifyVariable(method = "Lvazkii/patchouli/client/book/text/TextLayouter;layout(Lnet/minecraft/client/gui/Font;Ljava/util/List;)V", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private Font patchfulFont(Font font) {
        return ClientEmojiHandler.oldFontRenderer;
    }
}
