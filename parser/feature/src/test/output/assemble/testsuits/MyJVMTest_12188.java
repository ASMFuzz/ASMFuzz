import java.util.function.*;

public class MyJVMTest_12188 {

    static Object o = -1120361626;

    String foo(Object o) {
        return "foo";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12188().foo(o));
    }
}
