import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_5646 {

    static ByteBuffer bb = null;

    ByteBuffer extend(ByteBuffer bb) {
        ByteBuffer x = ByteBuffer.allocate(2 * bb.capacity() + 10);
        bb.flip();
        x.put(bb);
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5646().extend(bb));
    }
}
