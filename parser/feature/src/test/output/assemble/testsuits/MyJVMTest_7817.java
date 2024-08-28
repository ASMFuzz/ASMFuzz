import java.util.regex.Pattern;

public class MyJVMTest_7817 {

    static String s = "(d8z'RtD+J";

    static Pattern pattern = Pattern.compile("");

    String test(String s) {
        pattern.matcher(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7817().test(s);
    }
}
