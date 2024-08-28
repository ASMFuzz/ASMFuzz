import java.io.*;
import java.util.*;

public class MyJVMTest_6143 {

    static byte[] data = { -7, -28, -26, -37, -104, 22, -102, -94, -19, -54 };

    Object deserialize(byte[] data) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6143().deserialize(data));
    }
}
