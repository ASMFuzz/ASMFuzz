import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_13876 {

    static PageFormat pf = new PageFormat();

    static Font textFont = null;

    static AffineTransform gxTx = null;

    static String page = ",04E3em|&X";

    static boolean useFM = true;

    String orient(PageFormat pf) {
        if (pf.getOrientation() == PageFormat.PORTRAIT) {
            return "Portrait";
        } else {
            return "Landscape";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13876().orient(pf));
    }
}
