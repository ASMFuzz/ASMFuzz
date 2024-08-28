import java.lang.invoke.MethodHandle;

public class MyJVMTest_17648 {

    static MethodHandle mh_nanoTime = null;

    long m1() throws Throwable {
        return (long) mh_nanoTime.invokeExact();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17648().m1());
    }
}
