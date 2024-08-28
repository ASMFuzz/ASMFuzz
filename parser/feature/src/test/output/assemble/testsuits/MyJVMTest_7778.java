import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_7778 {

    static Graphics g = new Graphics2D();

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 5;

    static int cols = 0;

    static int hgap = 1435443274;

    static int vgap = 1;

    static BufferedImage image = null;

    Graphics paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7778().paint(g);
    }
}
