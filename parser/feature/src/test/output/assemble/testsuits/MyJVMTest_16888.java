import javax.swing.*;
import java.awt.*;

public class MyJVMTest_16888 {

    static int pix1 = 6;

    static int pix2 = 8;

    int getEmptyPixel() {
        return 0xFFFFFFFF;
    }

    int subPixels(int pix1, int pix2) {
        if (pix1 == pix2) {
            return getEmptyPixel();
        }
        return pix1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16888().subPixels(pix1, pix2));
    }
}
