import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_13274 {

    static String name = "^__#r17ts9";

    static DirContext ctx = null;

    String destroySubcontext(String name) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13274().destroySubcontext(name);
    }
}
