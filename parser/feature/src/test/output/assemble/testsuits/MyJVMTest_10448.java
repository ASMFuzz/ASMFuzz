import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_10448 {

    static int sz = 6;

    static Charset cs = Charset.forName("UTF-16");

    char[] test(int sz) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(new byte[100]);
        ReadableByteChannel ch = Channels.newChannel(bis);
        Reader r = Channels.newReader(ch, cs.newDecoder(), sz);
        char[] arr = new char[100];
        System.out.println(r.read(arr, 0, arr.length));
        return arr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10448().test(sz);
    }
}
