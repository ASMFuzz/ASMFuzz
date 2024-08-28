import java.util.Arrays;

public class MyJVMTest_5116 {

    static Class c = null;

    static Object o = 6;

    Object[] test(Class c, Object o) {
        Object[] a = (Object[]) java.lang.reflect.Array.newInstance(c, 1);
        return a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5116().test(c, o)));
    }
}
