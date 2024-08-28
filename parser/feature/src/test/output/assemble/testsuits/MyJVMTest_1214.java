import java.awt.datatransfer.DataFlavor;

public class MyJVMTest_1214 {

    static String test_native = "x1t5dXQ7>(";

    static String[] test_natives_set = {"XX\\#}`N3;f","Euqnbo/$i3","N$-[x|(?'$","bb{gJDyQ4d","rh?!i[i)B;","t;F)e\"sK6[","[wni\\Rq*>z","!}?uue&{^/","O6SYcOaS9o","<EX=8Rgy2)"};

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
        new MyJVMTest_1214().initMappings();
    }
}
