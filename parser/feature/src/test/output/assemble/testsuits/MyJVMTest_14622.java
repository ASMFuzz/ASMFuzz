import java.lang.reflect.*;

public class MyJVMTest_14622 {

    static Class<?> clazz = null;

    static boolean expected = true;

    int test(Class<?> clazz, boolean expected) {
        if (clazz.isSynthetic() == expected)
            return 0;
        else {
            System.err.println("Unexpected synthetic status for " + clazz.getName() + " expected: " + expected + " got: " + (!expected));
            return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14622().test(clazz, expected));
    }
}
