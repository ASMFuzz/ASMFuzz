import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_10897 {

    static Name name = null;

    static String filterExpr = ".qqXoy+m[\"";

    static Object[] filterArgs = { 1, 5, 4, 2085456634, 0, 4, 7, 9, 352815084, 7 };

    static SearchControls cons = new SearchControls();

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(Name name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10897().search(name, filterExpr, filterArgs, cons));
    }
}
