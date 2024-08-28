import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_4163 {

    static Name name = null;

    static Object obj = 1011596107;

    static int attrsParam1 = 382;

    static Attributes attrs = new Attributes(attrsParam1);

    static DirContext ctx = null;

    Attributes bind(Name name, Object obj, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4163().bind(name, obj, attrs);
    }
}
