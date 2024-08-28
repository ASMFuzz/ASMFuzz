import java.sql.Connection;

public class MyJVMTest_9929 {

    static String url = "!$,N[?qDi#";

    boolean acceptsURL(final String url) {
        return url.startsWith("jdbc:nashorn:");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9929().acceptsURL(url));
    }
}
