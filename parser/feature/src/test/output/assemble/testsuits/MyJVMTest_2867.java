import java.io.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.crypto.*;
import javax.security.auth.callback.*;

public class MyJVMTest_2867 {

    static Callback[] callbacks = { null, null, null, null, null, null, null, null, null, null };

    static char[] PASSWORD = "changeit".toCharArray();

    static ProtectionParameter protection = null;

    Callback[] handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        System.out.println("** Callbackhandler invoked");
        for (int i = 0; i < callbacks.length; i++) {
            Callback cb = callbacks[i];
            if (cb instanceof PasswordCallback) {
                PasswordCallback pcb = (PasswordCallback) cb;
                pcb.setPassword(PASSWORD);
                break;
            }
        }
        return callbacks;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2867().handle(callbacks);
    }
}
