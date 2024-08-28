import java.io.*;
import java.security.*;
import java.security.spec.*;
import java.security.interfaces.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;

public class MyJVMTest_5803 {

    static byte b = 127;

    static CharSequence bufParam1 = null;

    static StringBuffer buf = new StringBuffer(bufParam1);

    char[] byte2hex(byte b, StringBuffer buf) {
        char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        int high = ((b & 0xf0) >> 4);
        int low = (b & 0x0f);
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
        return hexChars;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5803().byte2hex(b, buf);
    }
}
