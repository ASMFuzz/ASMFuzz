import java.util.Set;
import java.util.regex.Pattern;

public class MyJVMTest_16864 {

    static Pattern pattern = Pattern.compile(".*");

    String getValue() {
        return pattern.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16864().getValue());
    }
}
