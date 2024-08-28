import java.awt.*;
import java.awt.image.*;
import java.applet.*;

public class MyJVMTest_9161 {

    static int x = 1;

    static int y = 4;

    static int bImgParam1 = 177;

    static int bImgParam2 = 701;

    static int bImgParam3 = 722;

    static BufferedImage bImg = new BufferedImage(bImgParam1, bImgParam2, bImgParam3);

    boolean checkColor(int x, int y, BufferedImage bImg) {
        int pixelColor;
        int correctColor = Color.green.getRGB();
        pixelColor = bImg.getRGB(x, y);
        if (pixelColor != correctColor) {
            System.out.println("FAILURE: pixelColor " + Integer.toHexString(pixelColor) + " != correctColor " + Integer.toHexString(correctColor) + " at coordinates (" + x + ", " + y + ")");
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9161().checkColor(x, y, bImg));
    }
}
