import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;

public class MyJVMTest_9084 {

    static Frame eParam1Param1 = new Frame();

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 135;

    static String eParam3Param1Param1Param1Param1 = "Rg+]rTvNT#";

    static Frame eParam3Param1Param1Param1 = new Frame(eParam3Param1Param1Param1Param1);

    static Window eParam3Param1Param1 = new Window(eParam3Param1Param1Param1);

    static Window eParam3Param1 = new Window(eParam3Param1Param1);

    static Window eParam3 = new Window(eParam3Param1);

    static int eParam4 = 357;

    static int eParam5 = 921;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static ClippedImageCanvas c = null;

    WindowEvent windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9084().windowClosing(e);
    }
}
