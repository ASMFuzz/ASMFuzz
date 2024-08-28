import java.io.*;
import static java.awt.Color.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.print.*;
import java.awt.image.*;
import static java.awt.image.BufferedImage.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_14984 {

    static Frame eParam1Param1Param1Param1Param1Param1 = new Frame();

    static Window eParam1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1);

    static Window eParam1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1);

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 681;

    static Frame eParam3Param1Param1 = new Frame();

    static Window eParam3Param1 = new Window(eParam3Param1Param1);

    static GraphicsConfiguration eParam3Param2 = null;

    static Window eParam3 = new Window(eParam3Param1, eParam3Param2);

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3);

    static ImageCanvas c = null;

    WindowEvent windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14984().windowClosing(e);
    }
}
