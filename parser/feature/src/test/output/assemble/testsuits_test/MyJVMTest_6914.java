import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_6914 {

    static Font textFont = null;

    static AffineTransform gxTx = null;

    static String page = "pA`&}$82Eh";

    static boolean useFM = false;

    static Font physicalFont = null;

    Font getPhysicalFont() {
        if (physicalFont != null) {
            return physicalFont;
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] names = ge.getAvailableFontFamilyNames();
        for (String n : names) {
            switch(n.toLowerCase()) {
                case "dialog":
                case "dialoginput":
                case "serif":
                case "sansserif":
                case "monospaced":
                    break;
                default:
                    Font f = new Font(n, Font.PLAIN, 18);
                    if (f.canDisplayUpTo("AZaz09") == -1) {
                        physicalFont = f;
                        return f;
                    }
            }
        }
        physicalFont = new Font(Font.DIALOG, Font.PLAIN, 18);
        return physicalFont;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6914().getPhysicalFont());
    }
}
