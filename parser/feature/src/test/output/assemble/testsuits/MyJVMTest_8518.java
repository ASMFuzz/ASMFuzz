import java.net.*;
import java.io.*;

public class MyJVMTest_8518 {

    static String s = "UG*]?Z5F8Q";

    static URL[] urls = { null, null, null, null, null, null, null, null, null, null };

    URL[] p(String s, URL[] urls) {
        System.out.print(s);
        if (urls.length > 0) {
            for (int i = 0; i < urls.length - 1; i++) {
                System.out.print(urls[i] + " ");
            }
        }
        System.out.println(urls[urls.length - 1]);
        return urls;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8518().p(s, urls);
    }
}
