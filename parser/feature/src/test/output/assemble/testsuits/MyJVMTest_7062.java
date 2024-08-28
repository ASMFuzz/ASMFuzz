import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_7062 {

    static String name = "H?Fu74f.iR";

    static String filterExpr = "t!94G2^i|f";

    static Object[] filterArgs = { 7, 711635512, 7, -7062205, -415441996, 6, 2, 6, 0, 0 };

    static SearchControls cons = new SearchControls();

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(String name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7062().search(name, filterExpr, filterArgs, cons));
    }
}
