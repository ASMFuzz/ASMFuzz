import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;

public class MyJVMTest_18094 {

    static GraphicsConfiguration eParam1Param1Param1Param1 = null;

    static Frame eParam1Param1Param1 = new Frame(eParam1Param1Param1Param1);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 625;

    static String eParam3Param1Param1Param1Param1Param1 = "x~& Vn\"a,X";

    static Frame eParam3Param1Param1Param1Param1 = new Frame(eParam3Param1Param1Param1Param1Param1);

    static Window eParam3Param1Param1Param1 = new Window(eParam3Param1Param1Param1Param1);

    static Window eParam3Param1Param1 = new Window(eParam3Param1Param1Param1);

    static GraphicsConfiguration eParam3Param1Param2 = null;

    static Window eParam3Param1 = new Window(eParam3Param1Param1, eParam3Param1Param2);

    static GraphicsConfiguration eParam3Param2 = null;

    static Window eParam3 = new Window(eParam3Param1, eParam3Param2);

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3);

    static String fontname = "zIk/<CiJ:[";

    WindowEvent windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18094().windowClosing(e);
    }
}
