import java.util.concurrent.Callable;

public class MyJVMTest_15539 {

    static A2 t = null;

    static Callable<A2> ct = null;

    String m(A2 t, Callable<A2> ct) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15539().m(t, ct));
    }
}
