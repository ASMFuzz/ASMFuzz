import java.sql.Connection;

public class MyJVMTest_751 {

    static String url = "brjfZVs9>3";

    boolean acceptsURL(final String url) {
        return url.startsWith("jdbc:nashorn:");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_751().acceptsURL(url));
    }
}
