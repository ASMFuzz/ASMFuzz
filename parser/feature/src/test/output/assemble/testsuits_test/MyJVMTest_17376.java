import java.util.regex.Pattern;

public class MyJVMTest_17376 {

    static String s = "kY\\LKGxG4+";

    static Pattern pattern = Pattern.compile("");

    String test(String s) {
        pattern.matcher(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17376().test(s);
    }
}
