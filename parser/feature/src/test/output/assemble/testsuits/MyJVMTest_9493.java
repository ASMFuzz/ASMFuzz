import java.net.URL;

public class MyJVMTest_9493 {

    static String urlParam1 = "eRbj9WVV]M";

    static URL url = new URL(urlParam1);

    static String expected = ";tt#P, w7?";

    URL check(URL url, String expected) {
        if (!url.toString().equals(expected)) {
            throw new AssertionError("Expected " + url + " to equal " + expected);
        }
        return url;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9493().check(url, expected);
    }
}
