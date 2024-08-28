import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_6332 {

    Dimension getPreferredSize() {
        return new Dimension(preferredSize, preferredSize);
    }

    static int preferredSize = 0;

    static int tabNumber = -2047845180;

    Dimension getMinimumSize() {
        return getPreferredSize();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6332().getMinimumSize());
    }
}
