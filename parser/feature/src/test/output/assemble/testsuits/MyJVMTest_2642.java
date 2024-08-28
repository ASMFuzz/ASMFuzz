import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2642 {

    static String[] s = { "i[0ULC8>9 ", "B hbN`@yOp", "P}}cl4M2Js", "R}f!^-*W`$", "z]aaogEvPh", "gwmm5_.@|e", "o)D9Gv,]TH", "UOSf8D/mdE", "*>TFvEB!QS", "Pn8p!By-&>" };

    static int NONE = 0;

    static int SHIFT = 1;

    static int CTRL = 2;

    static int ALT = 3;

    static boolean debug = true;

    static boolean autorun = false;

    static int testModifier = NONE;

    static Frame f = null;

    String[] initParams(String[] s) {
        if (s.length != 3) {
            autorun = true;
            debug = false;
            testModifier = NONE;
        } else {
            autorun = Boolean.valueOf(s[0]);
            debug = Boolean.valueOf(s[1]);
            if (s[2].equals("NONE")) {
                testModifier = NONE;
            }
            if (s[2].equals("SHIFT")) {
                testModifier = SHIFT;
            }
            if (s[2].equals("CTRL")) {
                testModifier = CTRL;
            }
            if (s[2].equals("ALT")) {
                testModifier = ALT;
            }
        }
        System.out.println("Autorun : " + autorun);
        System.out.println("Debug mode : " + debug);
        System.out.println("Modifier to verify : " + testModifier);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2642().initParams(s);
    }
}
