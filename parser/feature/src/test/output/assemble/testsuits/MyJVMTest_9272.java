import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;

public class MyJVMTest_9272 {

    static Frame eParam1Param1Param1Param1Param1 = new Frame();

    static Window eParam1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1);

    static GraphicsConfiguration eParam1Param1Param1Param2 = null;

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1, eParam1Param1Param1Param2);

    static GraphicsConfiguration eParam1Param1Param2 = null;

    static Window eParam1Param1 = new Window(eParam1Param1Param1, eParam1Param1Param2);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 503;

    static GraphicsConfiguration eParam3Param1Param1Param1Param1 = null;

    static Frame eParam3Param1Param1Param1 = new Frame(eParam3Param1Param1Param1Param1);

    static Window eParam3Param1Param1 = new Window(eParam3Param1Param1Param1);

    static GraphicsConfiguration eParam3Param1Param2 = null;

    static Window eParam3Param1 = new Window(eParam3Param1Param1, eParam3Param1Param2);

    static GraphicsConfiguration eParam3Param2 = null;

    static Window eParam3 = new Window(eParam3Param1, eParam3Param2);

    static int eParam4 = 208;

    static int eParam5 = 223;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static ClippedImageCanvas c = null;

    WindowEvent windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9272().windowClosing(e);
    }
}
