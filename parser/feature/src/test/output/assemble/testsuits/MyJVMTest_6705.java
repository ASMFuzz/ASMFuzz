import java.util.*;
import javax.security.auth.*;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.*;

public class MyJVMTest_6705 {

    static CallbackHandler callbackHandler = null;

    boolean login() throws LoginException {
        if (callbackHandler == null) {
            throw new LoginException("Error: no CallbackHandler available " + "to garner authentication information from the user");
        } else {
            System.out.println("DefaultHandlerModule got CallbackHandler: " + callbackHandler.toString());
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6705().login());
    }
}
