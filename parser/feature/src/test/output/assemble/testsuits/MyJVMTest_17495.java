import java.util.*;
import java.io.*;

public class MyJVMTest_17495 {

    static byte[] sf = { 127, -22, -49, 43, 33, 34, -39, 60, -108, 32 };

    Object deserialize(byte[] sf) throws Throwable {
        return new ObjectInputStream(new ByteArrayInputStream(sf)).readObject();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17495().deserialize(sf));
    }
}
