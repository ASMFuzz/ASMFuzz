public class MyJVMTest_12429 {

    static int testid = 1;

    static String have = "peNTR};f^P";

    static String expect = "srt]^^h`%K";

    String check(int testid, String have, String expect) throws Exception {
        if ((have == null && have != expect) || (have != null && !have.equals(expect))) {
            String msg = "TEST " + testid + ": HAVE \"" + have + "\" EXPECT \"" + expect + "\"";
            System.out.println("StringConversion: " + msg);
            throw new Exception(msg);
        }
        return have;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12429().check(testid, have, expect);
    }
}
