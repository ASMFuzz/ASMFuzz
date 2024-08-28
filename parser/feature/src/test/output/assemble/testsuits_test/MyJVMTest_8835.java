import java.util.function.*;

public class MyJVMTest_8835 {

    static Object o = 0;

    String foo(Object o) {
        return "foo";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8835().foo(o));
    }
}
