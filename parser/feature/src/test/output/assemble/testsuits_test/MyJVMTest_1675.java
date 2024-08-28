import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_1675 {

    static Name name = null;

    static String filterExpr = "x\\AqLiB ,T";

    static Object[] filterArgs = { 0, 4, 0, 2095427040, 0, 0, 8, 8, 0, 5 };

    static SearchControls cons = new SearchControls();

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(Name name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1675().search(name, filterExpr, filterArgs, cons));
    }
}
