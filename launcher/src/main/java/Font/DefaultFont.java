package Font;

import java.awt.*;

public class DefaultFont extends Font {
    String fontName = "Serif";
    int fontStyle = Font.PLAIN;
    int size = 12;

    public DefaultFont(String name, int style, int size) {
        super(name, style, size);
    }
}
