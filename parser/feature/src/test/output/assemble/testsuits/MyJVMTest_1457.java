import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_1457 {

    double randDblCoord() {
        return Math.random() * 60 - 10;
    }

    static CubicCurve2D cubic = new CubicCurve2D.Double();

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 331965308;

    static int cols = 9;

    static int hgap = 5;

    static int vgap = 5;

    void randomize() {
        cubic.setCurve(randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1457().randomize();
    }
}
