import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;

public class MyJVMTest_17734 {

    static String test_encoded = "#Iq*b,Pd/&";

    static DataFlavor test_flavor1 = null, test_flavor2 = null;

    static String[] test_natives_set = {"xa;Bzqu}{!","\\H@41/b$,=","Du6D6:j~Z#","eVPr)q%1I_","l(6~|z*GWC","+EFjY{2r!n","T9u#l5N5Ca","+jE&]E8' L","x=eQ}XI |B","xW+{5*r73E"};

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
        new MyJVMTest_17734().initMappings();
    }
}
