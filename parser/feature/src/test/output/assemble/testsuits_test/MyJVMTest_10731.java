import java.io.*;
import javax.management.*;

public class MyJVMTest_10731 {

    static Object obj = 3;

    ByteArrayOutputStream test(Object obj) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object newObj = ois.readObject();
        if (!obj.equals(newObj)) {
            throw new RuntimeException("Serialization/deserialization failed.");
        }
        return baos;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10731().test(obj);
    }
}
