import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_366 {

    static String name = "Vw^ KgEPP|";

    static int attrsParam1 = 629;

    static Attributes attrs = new Attributes(attrsParam1);

    static DirContext ctx = null;

    DirContext createSubcontext(String name, Attributes attrs) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_366().createSubcontext(name, attrs));
    }
}
