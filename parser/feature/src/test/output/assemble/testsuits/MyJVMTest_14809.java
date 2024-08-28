import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_14809 {

    static Graphics2D g2d = null;

    static Rectangle rect = new Rectangle();

    Graphics2D draw(Graphics2D g2d) {
        g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
        return g2d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14809().draw(g2d);
    }
}
