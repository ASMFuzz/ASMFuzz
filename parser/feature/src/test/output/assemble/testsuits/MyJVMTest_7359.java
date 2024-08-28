import javax.swing.*;
import java.awt.*;

public class MyJVMTest_7359 {

    static int pix1 = -549016062;

    static int pix2 = 0;

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
        System.out.println(new MyJVMTest_7359().subPixels(pix1, pix2));
    }
}
