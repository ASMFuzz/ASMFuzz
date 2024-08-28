import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_5355 {

    Dimension getPreferredSize() {
        return new Dimension(preferredSize, preferredSize);
    }

    static int preferredSize = 7;

    static Font textFont = null;

    static AffineTransform gxTx = null;

    static String page = "[z=5$n0~`H";

    static boolean useFM = false;

    Dimension getMinimumSize() {
        return getPreferredSize();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5355().getMinimumSize());
    }
}
