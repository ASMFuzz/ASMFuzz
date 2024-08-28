import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.text.*;

public class MyJVMTest_16413 {

    static Graphics g1 = new Graphics2D();

    Graphics paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        String str = "String containing unclosed parenthesis (.";
        g.drawString(str, 20, 40);
        return g1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16413().paint(g1);
    }
}
