import java.awt.datatransfer.DataFlavor;

public class MyJVMTest_10414 {

    static String test_native = "r!eBhia24&";

    static String[] test_natives_set = {"*c%z2F'a,9","/am0+/!qu{","YC=\"'w[mIP","*D!k<*tj=X",".;DND~wK>}","X?+ '^:}cv","``El]W [`[","OHE+EN_vBQ","1Wwug^faAf","ASm-cg{AH2"};

    static DataFlavor test_flavor1 = null, test_flavor2 = null, test_flavor3 = null, test_flavor4 = null;

    static DataFlavor[] test_flavors_set1 = {null,null,null,null,null,null,null,null,null,null}, test_flavors_set2 = {null,null,null,null,null,null,null,null,null,null};

    void initMappings() throws Exception {
        test_native = "TEST1";
        test_flavor1 = new DataFlavor(Class.forName("java.awt.Label"), "test1");
        test_flavor2 = new DataFlavor(Class.forName("java.awt.Button"), "test2");
        test_flavor3 = new DataFlavor(Class.forName("java.awt.Checkbox"), "test3");
        test_flavor4 = new DataFlavor(Class.forName("java.awt.List"), "test4");
        test_flavors_set1 = new DataFlavor[] { test_flavor1, test_flavor2 };
        test_flavors_set2 = new DataFlavor[] { test_flavor1, test_flavor2, test_flavor3, test_flavor4 };
        test_natives_set = new String[] { test_native };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10414().initMappings();
    }
}
