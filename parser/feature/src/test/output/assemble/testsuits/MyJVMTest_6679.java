import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_6679 {

    static Graphics2D g2d = null;

    static Rectangle rect = new Rectangle();

    Graphics2D fill(Graphics2D g2d) {
        g2d.fillRect(rect.x, rect.y, rect.width, rect.height);
        return g2d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6679().fill(g2d);
    }
}
