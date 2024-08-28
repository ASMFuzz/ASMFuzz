import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_11648 {

    static int w = 3;

    static int h = 3;

    static int cParam1 = 891;

    static Color c = new Color(cParam1);

    static int type = 3;

    static int refW = 7, refH = 0, refType = 9;

    static boolean refHasAlpha = false;

    static Color refColor = null;

    BufferedImage generateImage(int w, int h, Color c, int type) {
        BufferedImage img = new BufferedImage(w, h, type);
        Graphics g = img.getGraphics();
        g.setColor(c);
        g.fillRect(0, 0, w, h);
        return img;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11648().generateImage(w, h, c, type));
    }
}
