import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_4951 {

    static int w = 0;

    static int h = 2;

    static int refW = 7, refH = -1295277828, refType = 372578013;

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
        new MyJVMTest_4951().setDimensions(w, h);
    }
}
