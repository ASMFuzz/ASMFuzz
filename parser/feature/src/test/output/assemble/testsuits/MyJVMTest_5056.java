import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;

public class MyJVMTest_5056 {

    static String test_native1 = "k-dHe`TZOZ", test_encoded = "6JjDFZ.Pw[";

    static DataFlavor test_flavor1 = null, test_flavor2 = null;

    static String[] test_natives_set = {"_}$Md];]Z6","D!Y}v2/tdx","0)Du0'x}w=","J[FBoJbQRr","~aayYcO\\uz","A'qKL;FDBG","Ou>:c EJdL","pn%fslz%oM","Wj<2ROY=]t","gPh.1M'S~Q"};

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
        new MyJVMTest_5056().initMappings();
    }
}
