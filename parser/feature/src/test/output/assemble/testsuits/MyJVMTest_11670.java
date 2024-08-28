import java.util.function.Function;

public class MyJVMTest_11670 {

    static Function<String, Object> f = null;

    static String cookie = "deadbeef";

    Object f(Function<String, Object> f) {
        return f.apply("feed");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11670().f(f));
    }
}
