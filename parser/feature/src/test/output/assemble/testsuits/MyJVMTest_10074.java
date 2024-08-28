import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_10074 {

    static String name = "OGbvRB'GL\\";

    static DirContext ctx = null;

    Object lookupLink(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10074().lookupLink(name));
    }
}
