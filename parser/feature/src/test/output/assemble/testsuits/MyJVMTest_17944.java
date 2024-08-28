import java.util.*;
import java.util.concurrent.*;
import static java.util.Collections.*;
import java.lang.reflect.*;
import java.io.*;

public class MyJVMTest_17944 {

    static Object obj = -2044462420;

    byte[] serializedForm(Object obj) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            new ObjectOutputStream(baos).writeObject(obj);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17944().serializedForm(obj)));
    }
}
