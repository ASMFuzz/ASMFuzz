import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_6992 {

    static String name = "I=ciyibU3V";

    static int matchingAttributesParam1Param1Param1Param1 = 147;

    static Attributes matchingAttributesParam1Param1Param1 = new Attributes(matchingAttributesParam1Param1Param1Param1);

    static Attributes matchingAttributesParam1Param1 = new Attributes(matchingAttributesParam1Param1Param1);

    static Attributes matchingAttributesParam1 = new Attributes(matchingAttributesParam1Param1);

    static Attributes matchingAttributes = new Attributes(matchingAttributesParam1);

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(String name, Attributes matchingAttributes) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6992().search(name, matchingAttributes));
    }
}
