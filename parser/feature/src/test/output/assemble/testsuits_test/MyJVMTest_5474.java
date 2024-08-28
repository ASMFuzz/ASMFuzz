import java.security.InvalidKeyException;

public class MyJVMTest_5474 {

    static String MACAlgo = "ReKs2ot2Uv";

    static int lengthToCheck = 0;

    boolean isMacLengthExpected(String MACAlgo, int lengthToCheck) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("(\\d+)", java.util.regex.Pattern.CASE_INSENSITIVE);
        java.util.regex.Matcher m = p.matcher(MACAlgo);
        int val = 0;
        if (m.find()) {
            val = Integer.parseInt(m.group(1));
        }
        if ((val == 1) && (lengthToCheck == 20)) {
            return true;
        }
        return (val / 8) == lengthToCheck;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5474().isMacLengthExpected(MACAlgo, lengthToCheck));
    }
}
