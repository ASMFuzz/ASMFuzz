import java.util.function.Function;

public class MyJVMTest_2404 {

    static Function<String, Object> f = null;

    static String cookie = "deadbeef";

    Object f(Function<String, Object> f) {
        return f.apply("feed");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2404().f(f));
    }
}
