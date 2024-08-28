import java.awt.datatransfer.DataFlavor;

public class MyJVMTest_5272 {

    static String test_native1 = ",\"-DV/pr7x", test_native2 = "H;:Q=[,[B.", test_native3 = "`1^HZ@]n,^", test_native4 = "lKUaJ#,gI5";

    static String[] test_natives_set1 = {"q.C:t;MNun","_*5B[\"8m{<","ge|^xx,2[R","T`aj!(}+j}","a#ga|1vApx","8>hVOeu98U",")RDj=W-Abt","#>2V'7GijM","\"G#w,\\>pET","Yts^<4:XGA"}, test_natives_set2 = {"e%D~Dr=$&1","H0\"jS&%95I","XpVOxNY&R!","a[k78WyeEa","<N;:s xY1Q","iDx+)!.bxQ","sL_OcdSR1e","p)YM-4o%1/","{s;6WzRhE]",":fV^!*NSpR"};

    static DataFlavor test_flavor1 = null, test_flavor2 = null, test_flavor3 = null, test_flavor4 = null;

    static DataFlavor[] test_flavors_set1 = {null,null,null,null,null,null,null,null,null,null}, test_flavors_set2 = {null,null,null,null,null,null,null,null,null,null};

    void initMappings() throws Exception {
        test_native1 = "TEST1";
        test_native2 = "TEST2";
        test_native3 = "TEST3";
        test_native4 = "TEST4";
        test_flavor1 = new DataFlavor(Class.forName("java.awt.Label"), "test1");
        test_flavor2 = new DataFlavor(Class.forName("java.awt.Button"), "test2");
        test_flavor3 = new DataFlavor(Class.forName("java.awt.Checkbox"), "test3");
        test_flavor4 = new DataFlavor(Class.forName("java.awt.List"), "test4");
        test_flavors_set1 = new DataFlavor[] { test_flavor1, test_flavor2 };
        test_flavors_set2 = new DataFlavor[] { test_flavor3, test_flavor4 };
        test_natives_set1 = new String[] { test_native1, test_native2 };
        test_natives_set2 = new String[] { test_native3, test_native4 };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5272().initMappings();
    }
}
