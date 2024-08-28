import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_1859 {

    static BufferedImage bimg = null;

    BufferedImage getImage() {
        while (bimg == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        return bimg;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1859().getImage());
    }
}
