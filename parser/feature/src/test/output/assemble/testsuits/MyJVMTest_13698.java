import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;
import java.util.jar.Attributes;

public class MyJVMTest_13698 {

    static Name name = null;

    static int matchingAttributesParam1 = 930;

    static Attributes matchingAttributes = new Attributes(matchingAttributesParam1);

    static String[] attributesToReturn = { "`\"DQxU=rw$", "cS!HCO/NIz", "-%%*UIftR|", "YAYdSxGI5,", "e\\Y$e3Q'k&", "~|{x4\\weog", "1*8';2=cen", "Yv<ZIivbtg", "eewRQ+\"M]4", "E1[[[#pFRa" };

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(Name name, Attributes matchingAttributes, String[] attributesToReturn) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13698().search(name, matchingAttributes, attributesToReturn));
    }
}
