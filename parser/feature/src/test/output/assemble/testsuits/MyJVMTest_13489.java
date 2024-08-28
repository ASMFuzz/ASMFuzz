import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_13489 {

    static String name = "`ZP>}oLU~n";

    static DirContext ctx = null;

    NamingEnumeration<Binding> listBindings(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13489().listBindings(name));
    }
}
