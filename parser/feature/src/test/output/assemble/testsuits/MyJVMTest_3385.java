import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_3385 {

    static String name = "MNiLQgoW5D";

    static int mod_op = 1465960470;

    static Attributes attrs = new Attributes();

    static DirContext ctx = null;

    Attributes modifyAttributes(String name, int mod_op, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3385().modifyAttributes(name, mod_op, attrs);
    }
}
