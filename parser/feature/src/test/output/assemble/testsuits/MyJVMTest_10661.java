import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_10661 {

    static String uriParam1 = "7PIC~r]YpJ";

    static String uriParam2 = "]s'kF9=lN3";

    static String uriParam3 = "}T17?y6[K.";

    static String uriParam4 = "KP=qU-Y`z]";

    static URI uri = new URI(uriParam1, uriParam2, uriParam3, uriParam4);

    static String connParam1Param1 = "S%XLkVcDT\"";

    static String connParam1Param2 = "8M\\ql/Wvc=";

    static int connParam1Param3 = 554;

    static String connParam1Param4 = "A6+OUjDK^N";

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
        System.out.println(new MyJVMTest_10661().put(uri, conn));
    }
}
