import java.util.*;
import java.nio.charset.*;
import java.nio.*;

public class MyJVMTest_15341 {

    static CharsetEncoder enc = null;

    static char c = Character.MIN_VALUE;

    boolean encodable1(CharsetEncoder enc, char c) {
        enc.reset();
        return enc.canEncode(c);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15341().encodable1(enc, c));
    }
}
