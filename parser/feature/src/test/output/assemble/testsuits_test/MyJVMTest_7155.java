import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_7155 {

    static String name = "\"fGki<}iSy";

    static Object obj = 3;

    static Attributes attrsParam1 = new Attributes();

    static Attributes attrs = new Attributes(attrsParam1);

    static DirContext ctx = null;

    Attributes bind(String name, Object obj, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7155().bind(name, obj, attrs);
    }
}
