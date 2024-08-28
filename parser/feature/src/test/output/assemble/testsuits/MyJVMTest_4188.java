import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class MyJVMTest_4188 {

    static ByteBuffer dst = null;

    static ReadableByteChannel ch = null;

    static ByteBuffer src = null;

    int read(ByteBuffer dst) {
        if (!src.hasRemaining())
            return -1;
        int nr = Math.min(src.remaining(), dst.remaining());
        ByteBuffer s = src.duplicate();
        s.limit(s.position() + nr);
        dst.put(s);
        src.position(src.position() + nr);
        return nr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4188().read(dst));
    }
}
