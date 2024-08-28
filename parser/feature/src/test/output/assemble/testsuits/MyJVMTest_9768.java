import java.net.*;
import java.io.*;

public class MyJVMTest_9768 {

    static String uriParam1 = "R<J!\"43!KB";

    static String uriParam2 = "GrN:w4BN#3";

    static String uriParam3 = "ykH}@wvwck";

    static URI uri = new URI(uriParam1, uriParam2, uriParam3);

    static String connParam1Param1 = "CB;B9}{iYX";

    static String connParam1Param2 = "n9tTNOG*S8";

    static int connParam1Param3 = 321;

    static String connParam1Param4 = "b;W;$)MA|8";

    static URL connParam1 = new URL(connParam1Param1, connParam1Param2, connParam1Param3, connParam1Param4);

    static URLConnection conn = new HttpURLConnection(connParam1);

    CacheRequest put(URI uri, URLConnection conn) throws IOException {
        System.out.println("put: " + uri);
        Thread.currentThread().dumpStack();
        URL url = uri.toURL();
        return new DeployCacheRequest(url, conn);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9768().put(uri, conn));
    }
}
