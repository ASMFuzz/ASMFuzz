import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.print.*;

public class MyJVMTest_10461 {

    static Frame eParam1Param1Param1Param1Param1 = new Frame();

    static Window eParam1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1);

    static GraphicsConfiguration eParam1Param1Param1Param2 = null;

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1, eParam1Param1Param1Param2);

    static GraphicsConfiguration eParam1Param1Param2 = null;

    static Window eParam1Param1 = new Window(eParam1Param1Param1, eParam1Param1Param2);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 64;

    static Frame eParam3Param1 = new Frame();

    static Window eParam3 = new Window(eParam3Param1);

    static int eParam4 = 280;

    static int eParam5 = 323;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static String text = "Twinkle twinkle little star, \n" + "How I wonder what you are. \n" + "Up above the world so high, \n" + "Like a diamond in the sky. \n" + "Twinkle, twinkle, little star, \n" + "How I wonder what you are!\n";

    WindowEvent windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10461().windowClosing(e);
    }
}
