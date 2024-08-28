import java.util.*;
import javax.security.auth.*;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.*;

public class MyJVMTest_5598 {

    static int attemptNumber = 1;

    boolean login() throws LoginException {
        if (attemptNumber == 1) {
            attemptNumber = 2;
            throw new LoginException("attempt 1 fails");
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5598().login());
    }
}
