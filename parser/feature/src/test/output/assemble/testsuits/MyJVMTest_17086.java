import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_17086 {

    static BufferedImage errorImg = null;

    static Graphics errorG = null;

    static BufferedImage bimg = null;

    void droperrorbuf() {
        errorImg = null;
        if (errorG != null) {
            errorG.dispose();
        }
        errorG = null;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17086().droperrorbuf();
    }
}
