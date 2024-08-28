import java.util.*;
import java.io.*;

public class MyJVMTest_16259 {

    static Object o = 8;

    byte[] serialBytes(Object o) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(o);
            oos.flush();
            oos.close();
            return bos.toByteArray();
        } catch (Throwable t) {
            throw new Error(t);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16259().serialBytes(o)));
    }
}
