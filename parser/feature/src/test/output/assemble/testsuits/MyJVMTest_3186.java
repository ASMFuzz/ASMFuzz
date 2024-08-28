import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_3186 {

    static String propName = "&|jO g9CS\\";

    static DirContext ctx = null;

    Object removeFromEnvironment(String propName) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3186().removeFromEnvironment(propName));
    }
}
