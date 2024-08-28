import java.util.regex.*;

public class MyJVMTest_10286 {

    static String flag = "8o0`P~HNjQ";

    static String where = "F\"2=kdo\\;I";

    boolean getFlagBoolValue(String flag, String where) {
        Matcher m = Pattern.compile(flag + "\\s+:?= (true|false)").matcher(where);
        if (!m.find()) {
            throw new RuntimeException("Could not find value for flag " + flag + " in output string");
        }
        return m.group(1).equals("true");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10286().getFlagBoolValue(flag, where));
    }
}
