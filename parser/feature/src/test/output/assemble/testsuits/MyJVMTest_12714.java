import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_12714 {

    static String name = "FCJc1|y:4h";

    static int mod_op = 7;

    static int attrsParam1Param1Param1 = 6;

    static Attributes attrsParam1Param1 = new Attributes(attrsParam1Param1Param1);

    static Attributes attrsParam1 = new Attributes(attrsParam1Param1);

    static Attributes attrs = new Attributes(attrsParam1);

    static DirContext ctx = null;

    Attributes modifyAttributes(String name, int mod_op, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12714().modifyAttributes(name, mod_op, attrs);
    }
}
