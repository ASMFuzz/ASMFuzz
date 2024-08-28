import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_6479 {

    static String uriParam1 = "de+&|&ScQ,";

    static String uriParam2 = "C@a\"qSu%+\\";

    static String uriParam3 = "T;2L\\0d'dn";

    static String uriParam4 = "\"7hIr`Jl/R";

    static String uriParam5 = "u+^=%$_8#i";

    static URI uri = new URI(uriParam1, uriParam2, uriParam3, uriParam4, uriParam5);

    static String connParam1Param1 = "h4|QGqeK\\x";

    static String connParam1Param2 = "+%>EAhQ>[E";

    static int connParam1Param3 = 523;

    static String connParam1Param4 = "cxvP/MoGU9";

    static URLStreamHandler connParam1Param5 = null;

    static URL connParam1 = new URL(connParam1Param1, connParam1Param2, connParam1Param3, connParam1Param4, connParam1Param5);

    static URLConnection conn = new HttpURLConnection(connParam1);

    CacheRequest put(URI uri, URLConnection conn) throws IOException {
        URL url = uri.toURL();
        return new DeployCacheRequest(url, conn);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6479().put(uri, conn));
    }
}
