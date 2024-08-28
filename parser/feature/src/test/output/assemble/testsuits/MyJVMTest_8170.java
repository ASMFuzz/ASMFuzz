import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_8170 {

    static int preferredSize = 8;

    static Font textFont = null;

    static AffineTransform gxTx = null;

    static String page = ";7QsqBF&(x";

    static boolean useFM = false;

    Dimension getPreferredSize() {
        return new Dimension(preferredSize, preferredSize);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8170().getPreferredSize());
    }
}
