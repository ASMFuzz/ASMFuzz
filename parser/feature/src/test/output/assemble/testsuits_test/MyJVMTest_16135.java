import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_16135 {

    double randDblCoord() {
        return Math.random() * 60 - 10;
    }

    static QuadCurve2D quad = new QuadCurve2D.Double();

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 0;

    static int cols = 1229882404;

    static int hgap = 0;

    static int vgap = -842580911;

    void randomize() {
        quad.setCurve(randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16135().randomize();
    }
}
