import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_7545 {

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
        new MyJVMTest_7545().droperrorbuf();
    }
}
