import java.io.*;

public class MyJVMTest_9920 {

    static ObjectStreamClass desc = null;

    static String message = "bodega";

    Class resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        throw new ClassNotFoundException(message);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9920().resolveClass(desc));
    }
}
