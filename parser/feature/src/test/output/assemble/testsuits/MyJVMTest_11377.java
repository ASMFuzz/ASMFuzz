import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11377 {

    static int rParam1Param1 = 23;

    static int rParam1Param2 = 84;

    static Point rParam1 = new Point(rParam1Param1, rParam1Param2);

    static Rectangle r = new Rectangle(rParam1);

    static Component c = new Container();

    Rectangle convertRectToScreen(Rectangle r, Component c) {
        Point p = new Point(r.x, r.y);
        SwingUtilities.convertPointToScreen(p, c);
        r.x = p.x;
        r.y = p.y;
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11377().convertRectToScreen(r, c);
    }
}
