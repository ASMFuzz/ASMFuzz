import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_7659 {

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 4;

    static int cols = 226875132;

    static int hgap = -1569983990;

    static int vgap = 8;

    static BufferedImage image = null;

    Dimension getPreferredSize() {
        if (image == null) {
            return new Dimension();
        } else {
            return new Dimension(image.getWidth(), image.getHeight());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7659().getPreferredSize());
    }
}
