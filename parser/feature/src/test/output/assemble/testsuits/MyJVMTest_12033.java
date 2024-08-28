import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_12033 {

    static String name = "ln85/P[Y4?";

    static String filter = "/CX2&gZSI.";

    static int consParam1 = 590;

    static long consParam2 = -9223372036854775808L;

    static int consParam3 = 706;

    static String[] consParam4 = { "-=Y7uGF(hi", "tI&I,'D0d6", "T)/;2P'#>0", "&j:=`<N=0$", "+FHZlIrM&P", "0'yE]ss]ab", "t`-B^=e!yB", "D<~Ej&fhK#", "?2&r<v%t=X", "9R'.;PIuV?" };

    static boolean consParam5 = true;

    static boolean consParam6 = true;

    static SearchControls cons = new SearchControls(consParam1, consParam2, consParam3, consParam4, consParam5, consParam6);

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(String name, String filter, SearchControls cons) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12033().search(name, filter, cons));
    }
}
