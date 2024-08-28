import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_13965 {

    static Frame eParam1Param1Param1 = new Frame();

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 776;

    static int eParam3 = 546;

    static int eParam4 = 883;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4);

    static Font textFont = null;

    static AffineTransform gxTx = null;

    static String page = "S,IEC1t![m";

    static boolean useFM = true;

    WindowEvent windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13965().windowClosing(e);
    }
}
