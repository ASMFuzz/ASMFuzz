import java.security.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_10215 {

    static byte[] e = null;

    byte[] getEncoded() {
        if (e == null) {
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            DataOutputStream ds = new DataOutputStream(bs);
            try {
                ds.writeLong(System.currentTimeMillis());
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            e = bs.toByteArray();
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10215().getEncoded()));
    }
}
