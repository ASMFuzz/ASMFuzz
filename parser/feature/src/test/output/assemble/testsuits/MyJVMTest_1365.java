import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_1365 {

    static Charset cs = null;

    void go() throws Exception {
        new Charset("", new String[] {}) {

            public CharsetDecoder newDecoder() {
                return null;
            }

            public CharsetEncoder newEncoder() {
                return null;
            }

            public boolean contains(Charset cs) {
                return false;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1365().contains(cs));
    }
}
