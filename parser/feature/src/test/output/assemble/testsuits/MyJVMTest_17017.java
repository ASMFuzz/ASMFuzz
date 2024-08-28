import java.io.*;
import java.util.*;

public class MyJVMTest_17017 {

    static Object obj = 8;

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
        System.out.println(Arrays.asList(new MyJVMTest_17017().serializedForm(obj)));
    }
}
