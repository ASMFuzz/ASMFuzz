import java.io.*;
import java.util.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.security.auth.callback.*;

public class MyJVMTest_5704 {

    static Callback[] callbacks = { null, null, null, null, null, null, null, null, null, null };

    static char[] password = "passphrase".toCharArray();

    static char[] wrongPassword = "wrong".toCharArray();

    static int useWrongPassword = 8;

    Callback[] handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        System.out.println("** Callbackhandler invoked");
        for (int i = 0; i < callbacks.length; i++) {
            Callback cb = callbacks[i];
            if (cb instanceof PasswordCallback) {
                System.out.println("Found PasswordCallback");
                PasswordCallback pcb = (PasswordCallback) cb;
                if (useWrongPassword == 0) {
                    pcb.setPassword(password);
                } else {
                    pcb.setPassword(wrongPassword);
                    useWrongPassword--;
                }
                break;
            }
        }
        return callbacks;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5704().handle(callbacks);
    }
}
