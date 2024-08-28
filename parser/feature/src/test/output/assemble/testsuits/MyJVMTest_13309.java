import java.util.Set;
import java.util.regex.Pattern;
import java.util.HashSet;

public class MyJVMTest_13309 {

    static Set<String> values = new HashSet<String>();

    String combine(Set<String> values) {
        return String.join("|", values);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13309().combine(values));
    }
}
