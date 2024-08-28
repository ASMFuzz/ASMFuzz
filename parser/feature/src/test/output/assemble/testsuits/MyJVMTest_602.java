import java.net.*;
import java.io.*;

public class MyJVMTest_602 {

    static String uriParam1 = "Wmoov71xU%";

    static String uriParam2 = "W_TN4'?)Ts";

    static String uriParam3 = "Pv:%h5yWJ>";

    static int uriParam4 = 190;

    static String uriParam5 = "vJ|d_4?{Wv";

    static String uriParam6 = "]C0_/)~L`C";

    static String uriParam7 = "o&\\$<HR0[9";

    static URI uri = new URI(uriParam1, uriParam2, uriParam3, uriParam4, uriParam5, uriParam6, uriParam7);

    static String connParam1Param1Param1Param1Param1 = "4]~~y<}Ls9";

    static URL connParam1Param1Param1Param1 = new URL(connParam1Param1Param1Param1Param1);

    static String connParam1Param1Param1Param2 = "rh>Ct]ww!c";

    static URLStreamHandler connParam1Param1Param1Param3 = null;

    static URL connParam1Param1Param1 = new URL(connParam1Param1Param1Param1, connParam1Param1Param1Param2, connParam1Param1Param1Param3);

    static String connParam1Param1Param2 = "h;7,\"LB=I@";

    static URLStreamHandler connParam1Param1Param3 = null;

    static URL connParam1Param1 = new URL(connParam1Param1Param1, connParam1Param1Param2, connParam1Param1Param3);

    static String connParam1Param2 = "R.<}+mj4X\"";

    static URL connParam1 = new URL(connParam1Param1, connParam1Param2);

    static URLConnection conn = new HttpURLConnection(connParam1);

    CacheRequest put(URI uri, URLConnection conn) throws IOException {
        System.out.println("put: " + uri);
        Thread.currentThread().dumpStack();
        URL url = uri.toURL();
        return new DeployCacheRequest(url, conn);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_602().put(uri, conn));
    }
}
