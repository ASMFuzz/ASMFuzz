import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_1118 {

    static String name = "o^z1*?;*3J";

    static Object obj = 0;

    static Attributes attrs = new Attributes();

    static DirContext ctx = null;

    Attributes rebind(String name, Object obj, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1118().rebind(name, obj, attrs);
    }
}
