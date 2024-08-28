import java.security.CodeSource;
import java.net.URL;

public class MyJVMTest_7020 {

    static String thisURLParam1Param1 = "n;_lk%N*[k";

    static String thisURLParam1Param2 = "_e~euqi4v^";

    static int thisURLParam1Param3 = 366;

    static String thisURLParam1Param4 = "v|z3osJl\"E";

    static URL thisURLParam1 = new URL(thisURLParam1Param1, thisURLParam1Param2, thisURLParam1Param3, thisURLParam1Param4);

    static String thisURLParam2 = "#CR3>/q?cP";

    static URL thisURL = new URL(thisURLParam1, thisURLParam2);

    static String thatURLParam1 = "._lt)[^)y@";

    static URL thatURL = new URL(thatURLParam1);

    static boolean result = false;

    URL testImplies(URL thisURL, URL thatURL, boolean result) throws SecurityException {
        CodeSource thisCs = new CodeSource(thisURL, (java.security.cert.Certificate[]) null);
        CodeSource thatCs = new CodeSource(thatURL, (java.security.cert.Certificate[]) null);
        if (thisCs.implies(thatCs) != result) {
            throw new SecurityException("test failed");
        }
        return thatURL;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7020().testImplies(thisURL, thatURL, result);
    }
}
