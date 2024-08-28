import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_4324 {

    static Name name = null;

    static Attributes matchingAttributesParam1 = new Attributes();

    static Attributes matchingAttributes = new Attributes(matchingAttributesParam1);

    static String[] attributesToReturn = { "A;O?4d\\x7s", "?1u=J^Wt9}", "Yx4,Dr6|(l", "9EmT_?0:jN", "'/No~{$H2x", "S8PAdapWf@", "(ph9 iG$o]", "oBYS5#@hEr", "]rrIQ u\"^^", "' ;nz5,r~ " };

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(Name name, Attributes matchingAttributes, String[] attributesToReturn) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4324().search(name, matchingAttributes, attributesToReturn));
    }
}
