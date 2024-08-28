import java.io.*;
import javax.management.*;

public class MyJVMTest_1514 {

    static Object obj = -497851343;

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
        new MyJVMTest_1514().test(obj);
    }
}
