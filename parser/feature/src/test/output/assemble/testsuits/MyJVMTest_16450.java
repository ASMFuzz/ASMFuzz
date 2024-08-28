import java.nio.file.*;
import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_16450 {

    static byte[] bytes = { 42, 44, -103, -35, -115, -105, -23, -108, -72, 73 };

    Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object result = ois.readObject();
        ois.close();
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16450().deserialize(bytes));
    }
}
