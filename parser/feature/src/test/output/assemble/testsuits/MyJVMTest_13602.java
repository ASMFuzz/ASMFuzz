import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;

public class MyJVMTest_13602 {

    static int flags = 7;

    int printFlags(int flags) {
        System.out.print("flags:");
        if ((flags & GlyphVector.FLAG_HAS_POSITION_ADJUSTMENTS) != 0) {
            System.out.print(" pos");
        }
        if ((flags & GlyphVector.FLAG_HAS_TRANSFORMS) != 0) {
            System.out.print(" trans");
        }
        if ((flags & GlyphVector.FLAG_RUN_RTL) != 0) {
            System.out.print(" rtl");
        }
        if ((flags & GlyphVector.FLAG_COMPLEX_GLYPHS) != 0) {
            System.out.print(" complex");
        }
        if ((flags & GlyphVector.FLAG_MASK) == 0) {
            System.out.print(" none");
        }
        System.out.println();
        return flags;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13602().printFlags(flags);
    }
}
