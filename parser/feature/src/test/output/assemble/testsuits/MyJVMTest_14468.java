import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;

public class MyJVMTest_14468 {

    static String test_native1 = "is;Es$?<n5", test_encoded = "6BZF2GiY4K";

    static DataFlavor test_flavor1 = null, test_flavor2 = null;

    static String[] test_natives_set = {"0yq+YoTvzN","D^qtg7?7}p","Ml1CgU6HL|","XT|g!qPwI@","LE$A_I91.H","3E+je3%=SX","6\\w8f:(/=;","DI {/T[;`L","~n0%<Ad*NC","uQ'99(k1D5"};

    static DataFlavor[] test_flavors_set = {null,null,null,null,null,null,null,null,null,null};

    void initMappings() throws Exception {
        test_native1 = "TEST1";
        test_flavor1 = new DataFlavor(Class.forName("java.awt.Button"), "Button");
        String buttonMIME = test_flavor1.getMimeType();
        test_encoded = SystemFlavorMap.encodeJavaMIMEType(buttonMIME);
        test_flavor2 = SystemFlavorMap.decodeDataFlavor(test_encoded);
        test_flavors_set = new DataFlavor[] { test_flavor2 };
        test_natives_set = new String[] { test_encoded };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14468().initMappings();
    }
}
