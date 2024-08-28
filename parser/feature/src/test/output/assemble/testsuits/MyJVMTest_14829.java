import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_14829 {

    static int numtests = -924338449;

    static int numerrors = 2;

    static int numfillfailures = 780625305;

    static int numstrokefailures = 0;

    static boolean strict = false;

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 9;

    static int cols = 0;

    static int hgap = 9;

    static int vgap = -1539546876;

    int reportStatistics() {
        String connector = "";
        if (numfillfailures > 0) {
            System.out.print(numfillfailures + " fills ");
            connector = "and ";
        }
        if (numstrokefailures > 0) {
            System.out.print(connector + numstrokefailures + " strokes ");
        }
        int totalfailures = numfillfailures + numstrokefailures;
        if (totalfailures == 0) {
            System.out.print("0 ");
        }
        System.out.println("out of " + numtests + " tests failed...");
        int critical = numerrors;
        if (strict) {
            critical += totalfailures;
        }
        if (critical > 0) {
            throw new RuntimeException(critical + " tests had critical errors");
        }
        System.out.println("No tests had critical errors");
        return (numerrors + totalfailures);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14829().reportStatistics());
    }
}
