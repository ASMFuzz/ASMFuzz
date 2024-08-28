import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_9846 {

    static ByteBuffer buffer = null;

    static int size = 5;

    static String pathToStores = " w<zlQzh/&";

    ByteBuffer enlargeBuffer(ByteBuffer buffer, int size) {
        ByteBuffer bb = ByteBuffer.allocate(size);
        buffer.flip();
        bb.put(buffer);
        return bb;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9846().enlargeBuffer(buffer, size));
    }
}
