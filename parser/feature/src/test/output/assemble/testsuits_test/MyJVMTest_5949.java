import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.text.*;

public class MyJVMTest_5949 {

    static Graphics g1 = new Graphics2D();

    Graphics paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        String str = "Test string compound printing \u2203\u2200\u2211";
        g.drawString(str, 20, 40);
        return g1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5949().paint(g1);
    }
}
