import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_910 {

    static Name name = null;

    static int mod_op = 8;

    static int attrsParam1 = 261;

    static Attributes attrs = new Attributes(attrsParam1);

    static DirContext ctx = null;

    Attributes modifyAttributes(Name name, int mod_op, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_910().modifyAttributes(name, mod_op, attrs);
    }
}
