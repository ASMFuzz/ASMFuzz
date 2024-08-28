import java.net.URL;

public class MyJVMTest_336 {

    static String urlParam1 = "<[AgL*N/E3";

    static String urlParam2 = "CNWO`nW@GS";

    static int urlParam3 = 727;

    static String urlParam4 = "iB9{h.}Lv,";

    static URLStreamHandler urlParam5 = null;

    static URL url = new URL(urlParam1, urlParam2, urlParam3, urlParam4, urlParam5);

    static String expected = "V>/l,b+pqL";

    URL check(URL url, String expected) {
        if (!url.toString().equals(expected)) {
            throw new AssertionError("Expected " + url + " to equal " + expected);
        }
        return url;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_336().check(url, expected);
    }
}
