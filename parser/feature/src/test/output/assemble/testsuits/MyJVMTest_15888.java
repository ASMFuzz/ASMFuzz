import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_15888 {

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 0;

    static int cols = 9;

    static int hgap = 2;

    static int vgap = 0;

    double randDblCoord() {
        return Math.random() * 60 - 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15888().randDblCoord());
    }
}
