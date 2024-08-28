import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_1446 {

    static String uriParam1 = " z%WAqGpJz";

    static URI uri = new URI(uriParam1);

    static String connParam1Param1 = "I<oQB!25e*";

    static String connParam1Param2 = "0);VqKE-8}";

    static int connParam1Param3 = 40;

    static String connParam1Param4 = " S{m%S=C(-";

    static URL connParam1 = new URL(connParam1Param1, connParam1Param2, connParam1Param3, connParam1Param4);

    static URLConnection conn = new HttpURLConnection(connParam1);

    static URL _url = null;

    static URLConnection _conn = null;

    static InputStream is = null;

    static Map<String, List<String>> headers = new HashMap<String,List<String>>();

    CacheRequest put(URI uri, URLConnection conn) throws IOException {
        URL url = uri.toURL();
        return new DeployCacheRequest(url, conn);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1446().put(uri, conn));
    }
}
