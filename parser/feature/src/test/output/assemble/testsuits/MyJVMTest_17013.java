import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_17013 {

    static InputStream is = null;

    static Map<String, List<String>> headers = new HashMap<String,List<String>>();

    Map<String, List<String>> getHeaders() throws IOException {
        List<String> val = new ArrayList<>();
        val.add("HTTP/1.1 200 OK");
        headers.put(null, val);
        return headers;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17013().getHeaders().forEach((a, b) -> System.out.println(a + b));
    }
}
