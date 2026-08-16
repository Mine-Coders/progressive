package minecoders.progressive.util.helper;

import minecoders.progressive.Progressive;
import net.minecraft.text.MutableText;

@SuppressWarnings("unused")
public class TranslationHelper {
    public static MutableText screen(String path) {
        return Progressive.translation("screen", path);
    }

    public static MutableText screen(String path, Object... args) {
        return Progressive.translation("screen", path, args);
    }

    public static MutableText itemGroup(String path) {
        return Progressive.translation("itemGroup", path);
    }

    public static MutableText itemGroup(String path, Object... args) {
        return Progressive.translation("itemGroup", path, args);
    }

    public static MutableText command(String path) {
        return Progressive.translation("command", path);
    }

    public static MutableText command(String path, Object... args) {
        return Progressive.translation("command", path, args);
    }

    public static MutableText component(String path) {
        return Progressive.translation("component", path);
    }

    public static MutableText component(String path, Object... args) {
        return Progressive.translation("component", path, args);
    }
}
