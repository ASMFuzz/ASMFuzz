import java.net.URL;

public class MyJVMTest_7750 {

    static java.net.URL u = null;

    java.net.URLConnection openConnection(java.net.URL u) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7750().openConnection(u));
    }
}
