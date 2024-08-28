import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_17879 {

    static Graphics2D g2d = null;

    static int[] line = new int[4];

    Graphics2D draw(Graphics2D g2d) {
        g2d.drawLine(line[0], line[1], line[2], line[3]);
        return g2d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17879().draw(g2d);
    }
}
