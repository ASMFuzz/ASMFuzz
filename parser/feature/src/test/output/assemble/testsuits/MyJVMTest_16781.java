import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class MyJVMTest_16781 {

    static Graphics g = new Graphics2D();

    Graphics paint(Graphics g) {
        g.drawString("Deadlock or no deadlock?", 20, 80);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16781().paint(g);
    }
}
