import java.util.function.*;

public class MyJVMTest_17780 {

    static String o = "CMj;,{.teR";

    String foo(String o) {
        return "bar";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17780().foo(o));
    }
}
