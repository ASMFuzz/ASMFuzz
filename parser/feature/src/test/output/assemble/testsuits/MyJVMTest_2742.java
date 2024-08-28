import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_2742 {

    static String name = "7NK?WD_:x_";

    static String filter = "gnf);;p?Ku";

    static int consParam1 = 318;

    static long consParam2 = 9223372036854775807L;

    static int consParam3 = 25;

    static String[] consParam4 = { "<=b1Hk]h2J", "+j#f#jgrR|", "d/yDNyl4iw", "q,nh8{;sd ", "C6~Ie]i~y8", "qS5};M7z3{", "~$y|yMV[J4", "/i'9z^<5?:", "P3\"Y\\PM,G'", "S8UX .5'FG" };

    static boolean consParam5 = false;

    static boolean consParam6 = true;

    static SearchControls cons = new SearchControls(consParam1, consParam2, consParam3, consParam4, consParam5, consParam6);

    static DirContext ctx = null;

    NamingEnumeration<SearchResult> search(String name, String filter, SearchControls cons) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2742().search(name, filter, cons));
    }
}
