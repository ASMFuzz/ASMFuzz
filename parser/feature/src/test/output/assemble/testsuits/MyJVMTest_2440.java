import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_2440 {

    static String name = "Im|'ot_=${";

    static Attributes matchingAttributesParam1Param1 = new Attributes();

    static Attributes matchingAttributesParam1 = new Attributes(matchingAttributesParam1Param1);

    static Attributes matchingAttributes = new Attributes(matchingAttributesParam1);

    static String[] attributesToReturn = { "E|+fFOjb\"g", "5od\"{}waJ@", "Q->UzDM&3v", "Q2YqvlWV&m", "iFm\"- >fW5", "AKN)Ho]@Y4", "tmP#'{MRKv", "rE8QMN'Z&b", "k%OY[K!@'Z", "9\\=IBpz.`{" };

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(String name, Attributes matchingAttributes, String[] attributesToReturn) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2440().search(name, matchingAttributes, attributesToReturn));
    }
}
