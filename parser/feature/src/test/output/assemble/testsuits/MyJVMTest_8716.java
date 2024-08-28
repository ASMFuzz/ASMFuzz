import java.util.regex.Pattern;

public class MyJVMTest_8716 {

    static String s = "\\McHwT7SO2";

    static Pattern pattern = Pattern.compile("");

    String test(String s) {
        pattern.matcher(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8716().test(s);
    }
}
