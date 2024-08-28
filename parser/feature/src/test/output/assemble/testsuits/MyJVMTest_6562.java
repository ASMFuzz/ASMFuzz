import java.lang.invoke.MethodHandle;

public class MyJVMTest_6562 {

    static MethodHandle mh = null;

    static int[] testArray = new int[1];

    void test() throws Throwable {
        int[] a = (int[]) mh.invokeExact();
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6562().test();
    }
}
