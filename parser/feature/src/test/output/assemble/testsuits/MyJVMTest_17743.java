import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_17743 {

    static int preferredSize = 0;

    static Font textFont = null;

    static AffineTransform gxTx = null;

    static String page = "(Q$_Lk59)]";

    static boolean useFM = true;

    Dimension getPreferredSize() {
        return new Dimension(preferredSize, preferredSize);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17743().getPreferredSize());
    }
}
