import java.util.concurrent.Callable;

public class MyJVMTest_2322 {

    static A3 t = null;

    static Callable<A3> ct = null;

    String m(A3 t, Callable<A3> ct) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2322().m(t, ct));
    }
}
