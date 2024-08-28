import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_7173 {

    static String name = "eGrcEw[H6:";

    static DirContext ctx = null;

    Attributes getAttributes(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7173().getAttributes(name));
    }
}
