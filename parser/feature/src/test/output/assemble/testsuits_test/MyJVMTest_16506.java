import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_16506 {

    static String name = "cDwGx_xx{n";

    static int matchingAttributesParam1 = 220;

    static Attributes matchingAttributes = new Attributes(matchingAttributesParam1);

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(String name, Attributes matchingAttributes) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16506().search(name, matchingAttributes));
    }
}
