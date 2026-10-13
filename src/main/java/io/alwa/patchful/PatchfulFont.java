package io.alwa.patchful;

import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;

public class PatchfulFont extends Font {

    public PatchfulFont(Font font) {
        super(font.provider);
    }

    @Override
    public int width(String text) {
        return Mth.ceil(this.getSplitter().stringWidth(text));
    }

    @Override
    public int width(FormattedText text) {
        return Mth.ceil(this.getSplitter().stringWidth(text));
    }

    @Override
    public int width(FormattedCharSequence text) {
        return Mth.ceil(this.getSplitter().stringWidth(text));
    }
}
