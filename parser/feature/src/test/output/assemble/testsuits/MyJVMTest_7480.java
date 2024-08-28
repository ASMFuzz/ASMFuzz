import java.io.*;
import java.util.*;

public class MyJVMTest_7480 {

    static Object obj = 3;

    byte[] serializedForm(Object obj) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            new ObjectOutputStream(baos).writeObject(obj);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_7480().serializedForm(obj)));
    }
}
