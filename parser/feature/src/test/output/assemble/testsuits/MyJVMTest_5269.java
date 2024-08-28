import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class MyJVMTest_5269 {

    static int imgParam1 = 951;

    static int imgParam2 = 869;

    static int imgParam3 = 130;

    static int imgParam4Param1 = 376;

    static int imgParam4Param2 = 612;

    static byte[] imgParam4Param3 = { -110, 90, -98, 23, 7, -17, 66, 58, 31, -107 };

    static int imgParam4Param4 = 209;

    static boolean imgParam4Param5 = false;

    static IndexColorModel imgParam4 = new IndexColorModel(imgParam4Param1, imgParam4Param2, imgParam4Param3, imgParam4Param4, imgParam4Param5);

    static BufferedImage img = new BufferedImage(imgParam1, imgParam2, imgParam3, imgParam4);

    static String[] keys = { "Wd)~]7[<Nt", "*D~uWU6$Yz", "9{MX**DrRU", "` Qdg7!&]4", ">1Xn3 Y`T=", "1-1^'pYb6:", " XVi'PS-*O", "GuIT/cM%gI", "4(_ur7S36C", "Q^xGeuo:`l" };

    static String[] undefined = { "AvYBM9UK}2", "p9uyl'43{]", "&oo&sI)m$X", "0)!UkRj/L.", "h>g=v*}=l#", "r`pQc=V=Sz", "UYPWVZt%!^", "j,)90KU g,", "lV{0O;0@(+", ">hP#'ES_)6" };

    static Map<String, String> PROPS = new HashMap<String,String>();

    static Object UNDEF = Image.UndefinedProperty;

    String checkProperties(BufferedImage img, String[] keys, String[] undefined) {
        boolean numOK = true;
        if (keys.length == 0) {
            numOK = (img.getPropertyNames() == null);
        } else {
            numOK = (img.getPropertyNames().length == keys.length);
        }
        if (!numOK) {
            throw new RuntimeException("invalid number of properties");
        }
        for (String k : keys) {
            if (!img.getProperty(k).equals(PROPS.get(k))) {
                throw new RuntimeException("invalid property for name " + k);
            }
        }
        for (String k : undefined) {
            if (!img.getProperty(k).equals(UNDEF)) {
                throw new RuntimeException("property for name " + k + " must be undefined");
            }
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5269().checkProperties(img, keys, undefined);
    }
}
