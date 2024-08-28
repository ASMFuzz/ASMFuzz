import java.net.URL;

public class MyJVMTest_11791 {

    static java.net.URL u = null;

    static String spec = "H#M%smS{<T";

    static int start = 0;

    static int limit = 3;

    String parseURL(java.net.URL u, String spec, int start, int limit) {
        throw new RuntimeException();
        return spec;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11791().parseURL(u, spec, start, limit);
    }
}
