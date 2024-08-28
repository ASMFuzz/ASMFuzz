import java.io.*;
import java.util.*;

public class MyJVMTest_15613 {

    static byte[] data = { -38, -5, 98, -102, 83, -28, -18, -24, -7, 70 };

    Object deserialize(byte[] data) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15613().deserialize(data));
    }
}
