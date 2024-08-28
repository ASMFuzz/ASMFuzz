import java.nio.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Arrays;

public class MyJVMTest_17197 {

    static int i = 1685080856;

    byte[] i2b(int i) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        byte[] b = new byte[4];
        bb.putInt(i);
        bb.flip();
        bb.get(b);
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17197().i2b(i)));
    }
}
