import java.util.concurrent.Callable;

public class MyJVMTest_2612 {

    static A4 t = null;

    static Callable<A4> ct = null;

    String m(A4 t, Callable<A4> ct) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2612().m(t, ct));
    }
}
