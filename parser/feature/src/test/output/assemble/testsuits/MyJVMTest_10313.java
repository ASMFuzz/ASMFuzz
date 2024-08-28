import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_10313 {

    static String name = "]@FxZBINV!";

    static Object obj = 6;

    static int attrsParam1 = 126;

    static Attributes attrs = new Attributes(attrsParam1);

    static DirContext ctx = null;

    Attributes rebind(String name, Object obj, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10313().rebind(name, obj, attrs);
    }
}
