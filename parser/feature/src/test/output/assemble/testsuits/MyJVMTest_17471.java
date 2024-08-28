import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_17471 {

    static String name = "j#q)%;qzR'";

    static Object obj = 2;

    static DirContext ctx = null;

    String bind(String name, Object obj) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17471().bind(name, obj);
    }
}
