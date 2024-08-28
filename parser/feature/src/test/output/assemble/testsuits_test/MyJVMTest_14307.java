import java.nio.file.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.Arrays;

public class MyJVMTest_14307 {

    static Object o = 1;

    byte[] serialize(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return baos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14307().serialize(o)));
    }
}
