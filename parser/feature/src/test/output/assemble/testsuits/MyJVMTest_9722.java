import java.io.*;
import java.util.*;

public class MyJVMTest_9722 {

    static Serializable obj = null;

    byte[] serialize(Serializable obj) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        oos.close();
        return baos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9722().serialize(obj)));
    }
}
