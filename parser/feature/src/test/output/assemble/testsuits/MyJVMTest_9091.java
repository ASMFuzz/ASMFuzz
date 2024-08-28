import java.util.function.*;

public class MyJVMTest_9091 {

    static String o = "\"DyQ6;`4ns";

    String foo(String o) {
        return "bar";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9091().foo(o));
    }
}
