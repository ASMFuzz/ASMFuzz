import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;

public class MyJVMTest_15925 {

    static String fontname = "'5eEBqO<;T";

    static FontRenderContext frc = new FontRenderContext();

    static String text = "-+eov^MtR$";

    static boolean rtl = false;

    static int script = 0;

    GlyphVector makeGlyphVector(String fontname, FontRenderContext frc, String text, boolean rtl, int script) {
        Font font = new Font(fontname, Font.PLAIN, 14);
        System.out.println("asking for " + fontname + " and got " + font.getFontName());
        int flags = rtl ? 1 : 0;
        return font.layoutGlyphVector(frc, text.toCharArray(), 0, text.length(), flags);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15925().makeGlyphVector(fontname, frc, text, rtl, script));
    }
}
