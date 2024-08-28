import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_4024 {

    static Name name = null;

    static Object obj = 5;

    static Attributes attrs = new Attributes();

    static DirContext ctx = null;

    Attributes rebind(Name name, Object obj, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4024().rebind(name, obj, attrs);
    }
}
