import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_13377 {

    static Name name = null;

    static Object obj = 4;

    static int attrsParam1 = 310;

    static Attributes attrs = new Attributes(attrsParam1);

    static DirContext ctx = null;

    Attributes rebind(Name name, Object obj, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13377().rebind(name, obj, attrs);
    }
}
