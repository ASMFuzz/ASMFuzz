import java.util.regex.*;

public class MyJVMTest_7695 {

    static String flag = "Rj8 ?'\"dm[";

    static String where = "ce.h5usS`N";

    long getFlagLongValue(String flag, String where) {
        Matcher m = Pattern.compile(flag + "\\s+:?=\\s+\\d+").matcher(where);
        if (!m.find()) {
            throw new RuntimeException("Could not find value for flag " + flag + " in output string");
        }
        String match = m.group();
        return Long.parseLong(match.substring(match.lastIndexOf(" ") + 1, match.length()));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7695().getFlagLongValue(flag, where));
    }
}
