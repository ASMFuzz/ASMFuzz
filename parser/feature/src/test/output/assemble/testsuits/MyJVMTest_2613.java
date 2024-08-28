import java.util.concurrent.Callable;

public class MyJVMTest_2613 {

    static A1 t = null;

    static Callable<A1> ct = null;

    String m(A1 t, Callable<A1> ct) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2613().m(t, ct));
    }
}
