import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_14357 {

    static int w = 2;

    static int h = 1;

    static int refW = 1, refH = 0, refType = 0;

    static boolean refHasAlpha = false;

    static Color refColor = null;

    int setDimensions(int w, int h) {
        if (w != refW) {
            throw new RuntimeException("invalid width: " + w + ", expected: " + refW);
        }
        if (h != refH) {
            throw new RuntimeException("invalid height: " + h + ", expected: " + refH);
        }
        return h;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14357().setDimensions(w, h);
    }
}
