import java.io.*;

public class MyJVMTest_182 {

    static ObjectStreamClass desc = null;

    static String message = "bodega";

    Class<?> resolveClass(ObjectStreamClass desc) throws ClassNotFoundException {
        throw new ClassNotFoundException(message);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_182().resolveClass(desc));
    }
}
