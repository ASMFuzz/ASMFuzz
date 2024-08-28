import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_7638 {

    static Frame eParam1Param1 = new Frame();

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 345;

    static int eParam3 = 198;

    static int eParam4 = 98;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4);

    static int tabNumber = 7;

    WindowEvent windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7638().windowClosing(e);
    }
}
