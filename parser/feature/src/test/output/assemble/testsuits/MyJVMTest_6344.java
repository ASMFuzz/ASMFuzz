import java.io.Closeable;

public class MyJVMTest_6344 {

    static Class<?> c = null;

    static int error = 0;

    Class<?> test(Class<?> c) {
        System.out.println("\nTest " + c);
        if (Closeable.class.isAssignableFrom(c)) {
            System.out.println("Test passed!");
        } else {
            error++;
            System.out.println("Test failed!");
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6344().test(c);
    }
}
