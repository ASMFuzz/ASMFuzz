import java.util.*;
import java.nio.charset.*;
import java.nio.*;

public class MyJVMTest_5891 {

    static CharsetEncoder enc = null;

    static char c = Character.MIN_VALUE;

    boolean encodable1(CharsetEncoder enc, char c) {
        enc.reset();
        return enc.canEncode(c);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5891().encodable1(enc, c));
    }
}
