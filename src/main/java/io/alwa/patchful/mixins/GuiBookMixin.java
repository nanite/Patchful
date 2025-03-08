package io.alwa.patchful.mixins;

import com.hrznstudio.emojiful.ClientEmojiHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.patchouli.client.book.gui.GuiBook;

@Mixin(Screen.class)
public class GuiBookMixin {

    @Shadow protected Font font;

    @Inject(method = "init(Lnet/minecraft/client/Minecraft;II)V", at = {@At("TAIL")})
    public void patchfulInit(Minecraft minecraft, int width, int height, CallbackInfo ci) {
        var screenClass = (Screen)(Object)this;
        if (screenClass instanceof GuiBook) {
            this.font = ClientEmojiHandler.oldFontRenderer == null ? font : ClientEmojiHandler.oldFontRenderer;
        }
    }
}
