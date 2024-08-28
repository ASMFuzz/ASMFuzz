import java.awt.datatransfer.DataFlavor;

public class MyJVMTest_9819 {

    static String test_native1 = "MvN6Wj3F}`", test_native2 = "DStSo?h\\.V", test_native3 = "1u9K+cfbmu", test_native4 = "LryHwW,A0]";

    static String[] test_natives_set1 = {"DIEoVDHQ]+","q,yci4'67R","`.f'UQ*>D\"","!|l3QDYA=t","!45rfx4pO>","+N/j3 =ZKn","IaM|O[O\"!B","0}1AvNsz}~","kj3>v&XI}G","Cy5C7Uv`ae"}, test_natives_set2 = {"}P~qS;':@+","('Nyy_Tcpp","$|ucx7`cOY","<^DEPRvKuX",":YYq+Z<I y","K@q|V]1%!>","50TCds  Qc","YJU\"y_&k[j","@RNEVciK{5","0u/@2_y7GA"};

    static DataFlavor test_flav = null;

    static DataFlavor[] test_flavors_set = {null,null,null,null,null,null,null,null,null,null};

    void initMappings() throws Exception {
        test_native1 = "TEST1";
        test_native2 = "TEST2";
        test_native3 = "TEST3";
        test_native4 = "TEST4";
        test_flav = new DataFlavor(Class.forName("java.awt.Label"), "test1");
        test_flavors_set = new DataFlavor[] { test_flav };
        test_natives_set1 = new String[] { test_native1, test_native2 };
        test_natives_set2 = new String[] { test_native1, test_native2, test_native3, test_native4 };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9819().initMappings();
    }
}
