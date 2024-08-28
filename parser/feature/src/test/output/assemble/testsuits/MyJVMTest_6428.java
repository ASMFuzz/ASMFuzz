import static java.awt.Font.*;
import static java.awt.font.GlyphVector.*;

public class MyJVMTest_6428 {

    static int flags = 3;

    int printFlags(int flags) {
        System.out.print("flags:");
        if ((flags & FLAG_HAS_POSITION_ADJUSTMENTS) != 0) {
            System.out.print(" pos");
        }
        if ((flags & FLAG_HAS_TRANSFORMS) != 0) {
            System.out.print(" trans");
        }
        if ((flags & FLAG_RUN_RTL) != 0) {
            System.out.print(" rtl");
        }
        if ((flags & FLAG_COMPLEX_GLYPHS) != 0) {
            System.out.print(" complex");
        }
        if ((flags & FLAG_MASK) == 0) {
            System.out.print(" none");
        }
        System.out.println();
        return flags;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6428().printFlags(flags);
    }
}
