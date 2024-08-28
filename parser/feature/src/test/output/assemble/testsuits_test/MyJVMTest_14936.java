import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14936 {

    static String str = "d{d@&XF(3,";

    boolean isSupportedLAF(String str) {
        try {
            Class c = Class.forName(str);
            LookAndFeel laf = (LookAndFeel) c.newInstance();
            return laf.isSupportedLookAndFeel();
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14936().isSupportedLAF(str));
    }
}
