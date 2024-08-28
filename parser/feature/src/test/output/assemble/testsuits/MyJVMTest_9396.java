import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_9396 {

    static int preferredSize = 7;

    static int tabNumber = 143923184;

    Dimension getPreferredSize() {
        return new Dimension(preferredSize, preferredSize);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9396().getPreferredSize());
    }
}
