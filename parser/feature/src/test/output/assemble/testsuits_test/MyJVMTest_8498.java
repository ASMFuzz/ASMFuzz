import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_8498 {

    static URL _url = null;

    static URLConnection _conn = null;

    static InputStream is = null;

    static Map<String, List<String>> headers = new HashMap<String,List<String>>();

    int read() throws IOException {
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8498().read());
    }
}
