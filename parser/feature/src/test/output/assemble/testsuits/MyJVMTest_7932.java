import java.util.*;
import java.io.*;

public class MyJVMTest_7932 {

    static byte[] sf = { -53, -87, 104, 74, -94, 99, 79, -96, -118, 126 };

    Object deserialize(byte[] sf) throws Throwable {
        return new ObjectInputStream(new ByteArrayInputStream(sf)).readObject();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7932().deserialize(sf));
    }
}
