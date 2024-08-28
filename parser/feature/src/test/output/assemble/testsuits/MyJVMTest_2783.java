import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class MyJVMTest_2783 {

    static ByteBuffer src = null;

    static WritableByteChannel ch = null;

    static ByteBuffer dst = null;

    int write(ByteBuffer src) {
        int nr = Math.min(src.remaining(), dst.remaining());
        ByteBuffer s = src.duplicate();
        s.limit(s.position() + nr);
        dst.put(s);
        src.position(src.position() + nr);
        return nr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2783().write(src));
    }
}
