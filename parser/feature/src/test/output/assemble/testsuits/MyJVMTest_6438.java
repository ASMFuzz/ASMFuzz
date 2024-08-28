import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;

public class MyJVMTest_6438 {

    static String fontname = "HAwvi6JoN*";

    static AffineTransform frcParam1 = new AffineTransform();

    static Object frcParam2 = 0;

    static Object frcParam3 = 6;

    static FontRenderContext frc = new FontRenderContext(frcParam1, frcParam2, frcParam3);

    static String text = "<^Su5RUHP{";

    static boolean rtl = true;

    static int script = 0;

    GlyphVector makeGlyphVector(String fontname, FontRenderContext frc, String text, boolean rtl, int script) {
        Font font = new Font(fontname, Font.PLAIN, 14);
        System.out.println("asking for " + fontname + " and got " + font.getFontName());
        int flags = rtl ? 1 : 0;
        return font.layoutGlyphVector(frc, text.toCharArray(), 0, text.length(), flags);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6438().makeGlyphVector(fontname, frc, text, rtl, script));
    }
}
