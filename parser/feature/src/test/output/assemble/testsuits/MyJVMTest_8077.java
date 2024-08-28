import java.util.*;
import javax.security.auth.*;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.*;

public class MyJVMTest_8077 {

    static Subject subject = null;

    boolean commit() throws LoginException {
        com.sun.security.auth.NTUserPrincipal p = new com.sun.security.auth.NTUserPrincipal("testPrincipal");
        subject.getPrincipals().add(p);
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8077().commit());
    }
}
