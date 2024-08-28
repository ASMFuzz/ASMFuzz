import java.util.function.*;
import java.util.*;

public class MyJVMTest_1766 {

    void doSomeInvokedynamic() {
        String str = "world";
        Supplier<String> foo = () -> "hello, " + str;
        String res = foo.get();
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1766().doSomeInvokedynamic();
    }
}
