package io.alwa.patchful;

import net.minecraft.client.StringSplitter;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PatchfulFont extends Font {

    private final StringSplitter splitter;

    public PatchfulFont(Font fontRenderer) {
        super(fontRenderer.fonts, fontRenderer.filterFishyGlyphs);

        this.splitter = new StringSplitter((a, b) -> {
            return this.getFontSet(b.getFont()).getGlyphInfo(a, this.filterFishyGlyphs).getAdvance(b.isBold());
        });
    }

    FontSet getFontSet(ResourceLocation fontLocation) {
        return (FontSet) this.fonts.apply(fontLocation);
    }

    @Override
    public int width(String text) {
        return Mth.ceil(this.splitter.stringWidth(text));
    }

    @Override
    public int width(FormattedText text) {
        return Mth.ceil(this.splitter.stringWidth(text));
    }

    @Override
    public int width(FormattedCharSequence text) {
        return Mth.ceil(this.splitter.stringWidth(text));
    }
}
