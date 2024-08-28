import java.util.Set;
import java.util.regex.Pattern;

public class MyJVMTest_10732 {

    static String value = "$e>!0,`I<B";

    static Pattern pattern = Pattern.compile(".*");

    String setValue(String value) {
        this.pattern = Pattern.compile(value);
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10732().setValue(value);
    }
}
