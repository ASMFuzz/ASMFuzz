import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_13524 {

    static Name name = null;

    static Object obj = -1934962516;

    static Attributes attrs = new Attributes();

    static DirContext ctx = null;

    Attributes bind(Name name, Object obj, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13524().bind(name, obj, attrs);
    }
}
