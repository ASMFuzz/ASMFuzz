import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_17186 {

    static GraphicsConfiguration eParam1Param1Param1Param1Param1Param1 = null;

    static Frame eParam1Param1Param1Param1Param1 = new Frame(eParam1Param1Param1Param1Param1Param1);

    static Window eParam1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1);

    static GraphicsConfiguration eParam1Param1Param1Param2 = null;

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1, eParam1Param1Param1Param2);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static GraphicsConfiguration eParam1Param2 = null;

    static Window eParam1 = new Window(eParam1Param1, eParam1Param2);

    static int eParam2 = 728;

    static WindowEvent e = new WindowEvent(eParam1, eParam2);

    static int tabNumber = 7;

    WindowEvent windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17186().windowClosing(e);
    }
}
