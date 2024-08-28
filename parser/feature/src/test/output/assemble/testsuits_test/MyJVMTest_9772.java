import java.util.Set;
import java.util.regex.Pattern;

public class MyJVMTest_9772 {

    static String uri = "!po+|T(N=(";

    static Pattern pattern = Pattern.compile(".*");

    boolean matches(String uri) {
        return pattern.matcher(uri).find();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9772().matches(uri));
    }
}
