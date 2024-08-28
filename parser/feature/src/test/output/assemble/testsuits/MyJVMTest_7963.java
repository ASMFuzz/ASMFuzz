import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_7963 {

    static Graphics2D g = null;

    static int[][] rpts = { { 2, 0, 0, 0 }, { 12, 0, 1, 0 }, { 22, 0, 0, 1 }, { 32, 0, 1, 1 }, { 42, 0, 2, 1 }, { 52, 0, 1, 2 }, { 62, 0, 2, 2 }, { 72, 0, 5, 5 }, { 82, 0, 10, 10 }, { 97, 0, 15, 15 } };

    Graphics2D fillOvals(Graphics2D g) {
        for (int i = 0; i < rpts.length; i++) {
            g.fill(new Ellipse2D.Float(rpts[i][0], rpts[i][1], rpts[i][2], rpts[i][3]));
        }
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7963().fillOvals(g);
    }
}
