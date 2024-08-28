import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_17158 {

    static Graphics2D grefrender = null;

    static Graphics2D gtstrender = null;

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 6;

    static int cols = 0;

    static int hgap = 4;

    static int vgap = 0;

    void disposeGCs() {
        grefrender.dispose();
        gtstrender.dispose();
        grefrender = gtstrender = null;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17158().disposeGCs();
    }
}
