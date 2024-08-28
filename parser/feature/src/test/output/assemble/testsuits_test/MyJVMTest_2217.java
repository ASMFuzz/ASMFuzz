import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_2217 {

    static byte[] ba = { -31, 61, -44, -7, -19, -5, 1, -8, -30, -83 };

    static ByteBuffer bb = null;

    boolean equals(byte[] ba, ByteBuffer bb) {
        if (ba.length != bb.limit())
            return false;
        for (int i = 0; i < ba.length; i++) if (ba[i] != bb.get(i))
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2217().equals(ba, bb));
    }
}
