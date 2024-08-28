import java.io.*;
import java.util.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.security.auth.callback.*;

public class MyJVMTest_9162 {

    static byte[] streamParam1 = { -106, -38, -68, -71, -124, 36, -102, -11, -111, 68 };

    static InputStream stream = new ByteArrayInputStream(streamParam1);

    static char[] pw = { Character.MIN_VALUE, '0', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static char[] password = "passphrase".toCharArray();

    char[] engineLoad(InputStream stream, char[] pw) throws IOException {
        if (Arrays.equals(password, pw) == false) {
            Throwable t = new UnrecoverableKeyException("Wrong password: " + new String(pw));
            throw (IOException) new IOException("load() failed").initCause(t);
        }
        return pw;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9162().engineLoad(stream, pw);
    }
}
