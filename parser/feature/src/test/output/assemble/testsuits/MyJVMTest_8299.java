import java.util.*;
import java.io.*;

public class MyJVMTest_8299 {

    static Object oldObj = -1177449849;

    Object deepCopy(Object oldObj) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(oldObj);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bin);
            return ois.readObject();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8299().deepCopy(oldObj));
    }
}
