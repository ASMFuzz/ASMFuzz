import java.nio.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Arrays;

public class MyJVMTest_7648 {

    static int i = 0;

    byte[] i2b(int i) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        byte[] b = new byte[4];
        bb.putInt(i);
        bb.flip();
        bb.get(b);
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_7648().i2b(i)));
    }
}
