import java.util.function.*;

public class MyJVMTest_8207 {

    static String o = "s$):Z ]v~U";

    String foo(String o) {
        return "bar";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8207().foo(o));
    }
}
