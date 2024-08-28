import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_4489 {

    static PageFormat pf = new PageFormat();

    static Font textFont = null;

    static AffineTransform gxTx = null;

    static String page = "dAj6Oes&LB";

    static boolean useFM = false;

    String orient(PageFormat pf) {
        if (pf.getOrientation() == PageFormat.PORTRAIT) {
            return "Portrait";
        } else {
            return "Landscape";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4489().orient(pf));
    }
}
