import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_13447 {

    static Name name = null;

    static String filter = "L]>Oy'VvZO";

    static SearchControls cons = new SearchControls();

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(Name name, String filter, SearchControls cons) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13447().search(name, filter, cons));
    }
}
