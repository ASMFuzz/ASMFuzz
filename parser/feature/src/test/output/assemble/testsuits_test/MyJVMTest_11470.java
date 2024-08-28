import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_11470 {

    static byte[] ba = { -93, -79, 125, -13, 76, 6, 101, -44, -75, 124 };

    static ByteBuffer bb = null;

    boolean equals(byte[] ba, ByteBuffer bb) {
        if (ba.length != bb.limit())
            return false;
        for (int i = 0; i < ba.length; i++) if (ba[i] != bb.get(i))
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11470().equals(ba, bb));
    }
}
