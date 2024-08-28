import java.awt.datatransfer.DataFlavor;

public class MyJVMTest_14694 {

    static String test_native1 = "igcGRF^aQ1", test_native2 = "&W-FCr|cg^", test_native3 = "\\&Z~4|sF-=", test_native4 = "J!k:XO0!3Q";

    static String[] test_natives_set1 = {"NNP]Smy.Je","kTnFKp[#/\"",".t!p~* HGu","}h&sKDbnWy","R}xZF1\\[?0","qteX`[J%t`","OjN$I;<Kp3","rEN<>9gR}Q","9&h>pk_u u",">qWz4Q`6&c"}, test_natives_set2 = {"OADjIAgW T","r},0^)*-KH","b\"5MdE$8\\J","gU0zlJ9_g(","?H~2xm|+MH","Db3B)[u.y_"," &n{l8wYpk","S[\"Tz_/D]<","]O_DRwQ#P'","G)H&h *<PC"};

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
        new MyJVMTest_14694().initMappings();
    }
}
