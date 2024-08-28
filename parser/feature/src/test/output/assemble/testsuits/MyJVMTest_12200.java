import java.lang.annotation.*;

public class MyJVMTest_12200 {

    static Class clazz = null;

    static boolean expected = false;

    int test(Class clazz, boolean expected) {
        int status = (clazz.isAnnotation() == expected) ? 0 : 1;
        if (status == 1) {
            System.err.println("Unexpected annotation status for " + clazz);
        }
        return status;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12200().test(clazz, expected));
    }
}
