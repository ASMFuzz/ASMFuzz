import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_10099 {

    static String name = "=uJV$=ubu!";

    static String prefix = "HD\\,1}u{\"F";

    static DirContext ctx = null;

    String composeName(String name, String prefix) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10099().composeName(name, prefix));
    }
}
