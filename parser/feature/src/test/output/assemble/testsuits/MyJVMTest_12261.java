import java.util.*;
import java.nio.charset.*;
import java.nio.*;

public class MyJVMTest_12261 {

    static CharsetEncoder enc = null;

    static char c = '0';

    boolean encodable2(CharsetEncoder enc, char c) {
        enc.reset();
        try {
            enc.encode(CharBuffer.wrap(new char[] { c }));
            return true;
        } catch (CharacterCodingException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12261().encodable2(enc, c));
    }
}
