import java.util.Set;
import java.util.regex.Pattern;

public class MyJVMTest_1515 {

    static String value = "bpj`R!NEmx";

    static Pattern pattern = Pattern.compile(".*");

    String setValue(String value) {
        this.pattern = Pattern.compile(value);
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1515().setValue(value);
    }
}
