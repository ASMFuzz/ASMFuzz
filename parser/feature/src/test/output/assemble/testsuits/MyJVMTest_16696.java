import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_16696 {

    static String name = "GAUIV0h@m4";

    static DirContext ctx = null;

    Attributes getAttributes(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16696().getAttributes(name));
    }
}
