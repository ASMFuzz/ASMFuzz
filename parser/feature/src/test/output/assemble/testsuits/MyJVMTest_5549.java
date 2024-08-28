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

public class MyJVMTest_5549 {

    static GraphicsConfiguration eParam1Param1Param1Param1 = null;

    static Frame eParam1Param1Param1 = new Frame(eParam1Param1Param1Param1);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static GraphicsConfiguration eParam1Param2 = null;

    static Window eParam1 = new Window(eParam1Param1, eParam1Param2);

    static int eParam2 = 524;

    static WindowEvent e = new WindowEvent(eParam1, eParam2);

    static ImageCanvas c = null;

    WindowEvent windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5549().windowClosing(e);
    }
}
