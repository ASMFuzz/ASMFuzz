import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_17332 {

    static Name name = null;

    static int matchingAttributesParam1Param1 = 837;

    static Attributes matchingAttributesParam1 = new Attributes(matchingAttributesParam1Param1);

    static Attributes matchingAttributes = new Attributes(matchingAttributesParam1);

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(Name name, Attributes matchingAttributes) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17332().search(name, matchingAttributes));
    }
}
