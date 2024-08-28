import java.lang.reflect.Array;

public class MyJVMTest_9286 {

    static Class klass = null;

    static long longField = -9223372036854775808L;

    int test1(Class klass) {
        Object[] in = (Object[]) Array.newInstance(klass, 100);
        Object[] o = in;
        int v = 1;
        for (int i = 0; i < 100; i++) {
            longField = i;
            o = (A[]) o;
            v *= 2;
        }
        return v + o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9286().test1(klass));
    }
}
