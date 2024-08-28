import java.awt.datatransfer.DataFlavor;

public class MyJVMTest_649 {

    static String test_native1 = "KN+'Y+&$0C", test_native2 = "$C1FuMfDOf", test_native3 = "NY>ckBc5s4", test_native4 = "{w<NLZ{;*M";

    static String[] test_natives_set1 = {":OX4i\"x[] ","!r\"3t\\]DwJ","L[N`+D<?|G",">oI>-o*(-Y",",_bK-^cTyS","Zer&rWy3TQ","mP>O?Ic#SK","= IP!bJ+D4","FZX+9LTIok","C|D?1RZISQ"}, test_natives_set2 = {"TBrEeA.c.N",",[OO\\m==?q","=XH<0<b*V:","DL{y-R1t&M","bosqwkYWrX","gR'9;Dw4Fu","5%4vIh=c&7","dMrPt];^?w","bTJ|42k0NI","LqPj>UQR`/"};

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
        new MyJVMTest_649().initMappings();
    }
}
