import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11924 {

    static String[] s = { "ZyGCf6)Qm=", "5/w_U@XsG`", "'A$%H(7XD)", "z_b&5Zo I3", "&v&`<bqs%%", ">o(.ye`YU0", "@v7(ll^UBx", "XXM;e]0F]O", "w}-S~.c'&A", " ;VvA8lTTK" };

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
        new MyJVMTest_11924().initParams(s);
    }
}
