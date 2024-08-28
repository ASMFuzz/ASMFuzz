import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_4128 {

    static String name = "rRW>SoM5iB";

    static DirContext ctx = null;

    NamingEnumeration<Binding> listBindings(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4128().listBindings(name));
    }
}
