import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_10091 {

    static Name name = null;

    static int mod_op = 0;

    static Attributes attrs = new Attributes();

    static DirContext ctx = null;

    Attributes modifyAttributes(Name name, int mod_op, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
        return attrs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10091().modifyAttributes(name, mod_op, attrs);
    }
}
