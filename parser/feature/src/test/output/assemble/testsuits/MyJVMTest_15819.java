import java.util.concurrent.Callable;

public class MyJVMTest_15819 {

    static Object o = 1;

    static Callable<String> co = null;

    String m(Object o, Callable<String> co) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15819().m(o, co));
    }
}
