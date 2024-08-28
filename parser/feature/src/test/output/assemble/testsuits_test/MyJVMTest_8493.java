import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_8493 {

    static Name name = null;

    static Attributes attrs = new Attributes();

    static DirContext ctx = null;

    DirContext createSubcontext(Name name, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8493().createSubcontext(name, attrs));
    }
}
