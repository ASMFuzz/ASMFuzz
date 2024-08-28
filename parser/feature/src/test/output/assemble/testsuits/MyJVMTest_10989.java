import java.util.function.*;
import java.util.*;

public class MyJVMTest_10989 {

    void doSomeInvokedynamic() {
        String str = "world";
        Supplier<String> foo = () -> "hello, " + str;
        String res = foo.get();
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10989().doSomeInvokedynamic();
    }
}
