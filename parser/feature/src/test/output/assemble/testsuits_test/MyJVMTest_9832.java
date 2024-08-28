import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_9832 {

    static int TESTWIDTH = 0;

    static int TESTHEIGHT = 0;

    static BufferedImage bimg = null;

    Dimension getPreferredSize() {
        return new Dimension(TESTWIDTH, TESTHEIGHT);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9832().getPreferredSize());
    }
}
