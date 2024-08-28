import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_17209 {

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = -421788857;

    static int cols = 0;

    static int hgap = 3;

    static int vgap = 9;

    static BufferedImage image = null;

    Dimension getPreferredSize() {
        if (image == null) {
            return new Dimension();
        } else {
            return new Dimension(image.getWidth(), image.getHeight());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17209().getPreferredSize());
    }
}
