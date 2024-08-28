import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class MyJVMTest_14690 {

    static int imgParam1 = 946;

    static int imgParam2 = 166;

    static int imgParam3 = 159;

    static BufferedImage img = new BufferedImage(imgParam1, imgParam2, imgParam3);

    static String[] keys = { "1~qQ3Qu7m,", "@TTQK)K>2E", "IiW`#olVb ", ">:k(2OKs+c", "$G_k<X2JN~", "S^e.[<Gz 3", "#V9v-WoVD1", "lC]TP;{/!*", "@Q{kk|2PW<", "ke7-Kc8~];" };

    static String[] undefined = { "a}`#~x?V~R", "Q,[)wUf`M!", "'`_Ah@7![Y", "cm@h\\KU )7", "j.b&,Xnq\\\"", "\"AFa\\),T}z", "6p<uq>44t:", "X!V5[\"gtd/", ")*z%zNm]NB", "KSO)r~hz%6" };

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
        new MyJVMTest_14690().checkProperties(img, keys, undefined);
    }
}
