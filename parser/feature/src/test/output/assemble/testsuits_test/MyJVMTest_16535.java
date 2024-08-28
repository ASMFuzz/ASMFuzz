import java.security.CodeSource;
import java.net.URL;

public class MyJVMTest_16535 {

    static String thisURLParam1Param1 = "E/&>Qx+(Q9";

    static URL thisURLParam1 = new URL(thisURLParam1Param1);

    static String thisURLParam2 = "D'?p4cnuRe";

    static URL thisURL = new URL(thisURLParam1, thisURLParam2);

    static String thatURLParam1Param1Param1Param1 = ">pJM=c9!wu";

    static String thatURLParam1Param1Param1Param2 = "\\1TAXP<q\"Q";

    static int thatURLParam1Param1Param1Param3 = 14;

    static String thatURLParam1Param1Param1Param4 = "mE:)]etxZ)";

    static URL thatURLParam1Param1Param1 = new URL(thatURLParam1Param1Param1Param1, thatURLParam1Param1Param1Param2, thatURLParam1Param1Param1Param3, thatURLParam1Param1Param1Param4);

    static String thatURLParam1Param1Param2 = "+\\Nk@lBxb>";

    static URLStreamHandler thatURLParam1Param1Param3 = null;

    static URL thatURLParam1Param1 = new URL(thatURLParam1Param1Param1, thatURLParam1Param1Param2, thatURLParam1Param1Param3);

    static String thatURLParam1Param2 = "?yUD%PG9o_";

    static URL thatURLParam1 = new URL(thatURLParam1Param1, thatURLParam1Param2);

    static String thatURLParam2 = "w: * 8ZAGC";

    static URL thatURL = new URL(thatURLParam1, thatURLParam2);

    static boolean result = true;

    URL testImplies(URL thisURL, URL thatURL, boolean result) throws SecurityException {
        CodeSource thisCs = new CodeSource(thisURL, (java.security.cert.Certificate[]) null);
        CodeSource thatCs = new CodeSource(thatURL, (java.security.cert.Certificate[]) null);
        if (thisCs.implies(thatCs) != result) {
            throw new SecurityException("test failed");
        }
        return thatURL;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16535().testImplies(thisURL, thatURL, result);
    }
}
