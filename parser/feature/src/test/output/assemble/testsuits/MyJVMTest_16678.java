import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_16678 {

    static String name = "O.^3ans8gj";

    static Object obj = 6;

    static int attrsParam1Param1 = 420;

    static Attributes attrsParam1 = new Attributes(attrsParam1Param1);

    static Attributes attrs = new Attributes(attrsParam1);

    static DirContext ctx = null;

    Attributes bind(String name, Object obj, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16678().bind(name, obj, attrs);
    }
}
