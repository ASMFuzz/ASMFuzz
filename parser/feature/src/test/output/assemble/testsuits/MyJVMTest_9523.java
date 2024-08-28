import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_9523 {

    static String name = ".Qwl\";(.5>";

    static int attrsParam1Param1 = 536;

    static Attributes attrsParam1 = new Attributes(attrsParam1Param1);

    static Attributes attrs = new Attributes(attrsParam1);

    static DirContext ctx = null;

    DirContext createSubcontext(String name, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9523().createSubcontext(name, attrs));
    }
}
