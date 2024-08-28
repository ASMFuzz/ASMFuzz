import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_7776 {

    static Name name = null;

    static int matchingAttributesParam1 = 87;

    static Attributes matchingAttributes = new Attributes(matchingAttributesParam1);

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(Name name, Attributes matchingAttributes) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7776().search(name, matchingAttributes));
    }
}
