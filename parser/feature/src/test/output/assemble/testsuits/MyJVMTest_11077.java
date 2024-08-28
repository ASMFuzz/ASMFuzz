import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class MyJVMTest_11077 {

    static int scale = 0;

    static Properties pParam1 = new Properties();

    static Properties p = new Properties(pParam1);

    static Map<String, String> PROPS = new HashMap<String,String>();

    static int SZ = 100;

    BufferedImage generateImage(int scale, Properties p) {
        int x = (int) (SZ * scale);
        BufferedImage tmp = new BufferedImage(x, x, BufferedImage.TYPE_INT_RGB);
        return new BufferedImage(tmp.getColorModel(), tmp.getRaster(), tmp.isAlphaPremultiplied(), p);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11077().generateImage(scale, p));
    }
}
