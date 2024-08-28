import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_11412 {

    static Graphics g = new Graphics2D();

    static PageFormat pgFmt = new PageFormat();

    static int pgIndex = 7;

    static Font customFont = null;

    int print(Graphics g, PageFormat pgFmt, int pgIndex) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.translate(pgFmt.getImageableX(), pgFmt.getImageableY());
        g2D.setColor(Color.black);
        g2D.setFont(customFont);
        String str = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        g.drawString(str, 100, 100);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11412().print(g, pgFmt, pgIndex));
    }
}
