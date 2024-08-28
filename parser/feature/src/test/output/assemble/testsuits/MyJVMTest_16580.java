import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_16580 {

    static String name = "}C[lND?PX;";

    static String filterExpr = "B#n bK;d`o";

    static Object[] filterArgs = { 4, 3, -813749713, 0, 0, 6, 7, 0, 0, 5 };

    static SearchControls cons = new SearchControls();

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(String name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16580().search(name, filterExpr, filterArgs, cons));
    }
}
