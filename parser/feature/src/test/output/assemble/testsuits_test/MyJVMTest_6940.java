import java.nio.file.*;
import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_6940 {

    static byte[] bytes = { 71, 80, 53, -78, 103, 100, -91, -74, -18, 21 };

    Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object result = ois.readObject();
        ois.close();
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6940().deserialize(bytes));
    }
}
