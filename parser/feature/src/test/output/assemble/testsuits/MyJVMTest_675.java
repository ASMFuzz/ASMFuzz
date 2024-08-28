import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_675 {

    static ByteBuffer buffer = null;

    static int size = 0;

    static String pathToStores = "X, % f9u.b";

    ByteBuffer enlargeBuffer(ByteBuffer buffer, int size) {
        ByteBuffer bb = ByteBuffer.allocate(size);
        buffer.flip();
        bb.put(buffer);
        return bb;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_675().enlargeBuffer(buffer, size));
    }
}
