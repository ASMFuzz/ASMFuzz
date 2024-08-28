import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_15967 {

    static String uriParam1 = "3\"\"BZq.5:z";

    static String uriParam2 = "4iy+)a3Z#w";

    static String uriParam3 = "CkY)iHb\"F3";

    static String uriParam4 = "=)gqGDHAr$";

    static URI uri = new URI(uriParam1, uriParam2, uriParam3, uriParam4);

    static String connParam1Param1 = "] ,%;&`RyH";

    static String connParam1Param2 = "UPKvkLR8mv";

    static String connParam1Param3 = ";(gjK9aL59";

    static URL connParam1 = new URL(connParam1Param1, connParam1Param2, connParam1Param3);

    static URLConnection conn = new HttpURLConnection(connParam1);

    CacheRequest put(URI uri, URLConnection conn) throws IOException {
        URL url = uri.toURL();
        return new DeployCacheRequest(url, conn);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15967().put(uri, conn));
    }
}
