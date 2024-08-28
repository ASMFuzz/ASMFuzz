import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_2776 {

    static String name = "ZoL6%_,,uX";

    static DirContext ctx = null;

    Context createSubcontext(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2776().createSubcontext(name));
    }
}
