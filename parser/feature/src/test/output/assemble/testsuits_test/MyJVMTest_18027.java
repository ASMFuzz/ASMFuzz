import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.applet.Applet;

public class MyJVMTest_18027 {

    static Graphics g = new Graphics2D();

    static Thread badThread = null;

    Graphics paint(Graphics g) {
        g.drawString("Deadlock or no deadlock?", 20, 80);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18027().paint(g);
    }
}
