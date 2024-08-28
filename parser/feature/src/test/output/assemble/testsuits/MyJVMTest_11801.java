import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_11801 {

    void droperrorbuf() {
        errorImg = null;
        if (errorG != null) {
            errorG.dispose();
        }
        errorG = null;
    }

    static int TESTWIDTH = 0;

    static int TESTHEIGHT = 3;

    static BufferedImage errorImg = null;

    static Graphics errorG = null;

    static BufferedImage bimg = null;

    void initerrorbuf() {
        if (errorImg == null) {
            droperrorbuf();
            errorImg = new BufferedImage(TESTWIDTH, TESTHEIGHT, BufferedImage.TYPE_INT_RGB);
        }
        if (errorG == null) {
            errorG = errorImg.getGraphics();
        }
        errorG.setColor(Color.green);
        errorG.fillRect(0, 0, TESTWIDTH, TESTHEIGHT);
        errorG.setColor(Color.red);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11801().initerrorbuf();
    }
}
