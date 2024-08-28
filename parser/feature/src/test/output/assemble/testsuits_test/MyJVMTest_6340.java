import java.util.concurrent.Callable;

public class MyJVMTest_6340 {

    static Object o = 8;

    static Callable<String> co = null;

    String m(Object o, Callable<String> co) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6340().m(o, co));
    }
}
