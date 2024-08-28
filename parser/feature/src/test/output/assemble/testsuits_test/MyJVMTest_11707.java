import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_11707 {

    static String name = "r_}!0K]9XJ";

    static Attributes matchingAttributes = new Attributes();

    static String[] attributesToReturn = { "39vCNF`-wb", "PLzZbGx*^*", "E,DE!aVd5e", "Hx+($Iu7@*", "vE^d]&.Fxo", "d@O|@P}sKB", "m@$UYDBf7a", "?8s!1I7`O,", "v}h2}gLptm", "mghBxt*KCb" };

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(String name, Attributes matchingAttributes, String[] attributesToReturn) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11707().search(name, matchingAttributes, attributesToReturn));
    }
}
