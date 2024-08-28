import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;

public class MyJVMTest_8161 {

    static String test_encoded = "}~{~R/3xI;";

    static DataFlavor test_flavor1 = null, test_flavor2 = null;

    static String[] test_natives_set = {")S0t\"Bh'/'","570LRC4`qp","7SZvlyP-H.","*mt/[h+:Gy","G[2u3]lKZ0",".,;s:n}qgR","j^zE]d K)n","O&qsezdl;d","m7lGyiz&3l","C@nam[8u7G"};

    static DataFlavor[] test_flavors_set = {null,null,null,null,null,null,null,null,null,null};

    void initMappings() throws Exception {
        test_flavor1 = new DataFlavor(Class.forName("java.awt.Button"), "Button");
        String buttonMIME = test_flavor1.getMimeType();
        test_encoded = SystemFlavorMap.encodeJavaMIMEType(buttonMIME);
        test_flavor2 = SystemFlavorMap.decodeDataFlavor(test_encoded);
        test_flavors_set = new DataFlavor[] { test_flavor1 };
        test_natives_set = new String[] { test_encoded };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8161().initMappings();
    }
}
