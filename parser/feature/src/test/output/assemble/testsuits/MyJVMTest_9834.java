import java.security.*;
import java.io.*;

public class MyJVMTest_9834 {

    static byte[] e = null;

    String getFormat() {
        return new String("PKCS15");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9834().getFormat());
    }
}
