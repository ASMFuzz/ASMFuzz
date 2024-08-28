import java.util.*;
import java.nio.charset.*;
import java.nio.*;

public class MyJVMTest_2958 {

    static CharsetEncoder enc = null;

    static char c = 'y';

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
        System.out.println(new MyJVMTest_2958().encodable2(enc, c));
    }
}
