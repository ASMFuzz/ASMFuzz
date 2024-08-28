import java.util.regex.*;

public class MyJVMTest_17247 {

    static String flag = "8ypV?j$dN%";

    static String where = "jGsORa*dY~";

    long getFlagLongValue(String flag, String where) {
        Matcher m = Pattern.compile(flag + "\\s+:?=\\s+\\d+").matcher(where);
        if (!m.find()) {
            throw new RuntimeException("Could not find value for flag " + flag + " in output string");
        }
        String match = m.group();
        return Long.parseLong(match.substring(match.lastIndexOf(" ") + 1, match.length()));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17247().getFlagLongValue(flag, where));
    }
}
