import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_3898 {

    static String name = "=pxs2mGm#R";

    static Object obj = 5;

    static DirContext ctx = null;

    String rebind(String name, Object obj) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3898().rebind(name, obj);
    }
}
