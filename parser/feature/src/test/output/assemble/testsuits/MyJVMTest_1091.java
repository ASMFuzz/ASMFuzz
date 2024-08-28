import java.util.regex.*;

public class MyJVMTest_1091 {

    static String flag = "YBX9f:&Nz)";

    static String where = "L2qn~Ci3&{";

    boolean getFlagBoolValue(String flag, String where) {
        Matcher m = Pattern.compile(flag + "\\s+:?= (true|false)").matcher(where);
        if (!m.find()) {
            throw new RuntimeException("Could not find value for flag " + flag + " in output string");
        }
        return m.group(1).equals("true");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1091().getFlagBoolValue(flag, where));
    }
}
