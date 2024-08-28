public class MyJVMTest_3115 {

    static int testid = -1113112352;

    static String have = "koLH0Qm(R%";

    static String expect = "L.e]rR~Aq9";

    String check(int testid, String have, String expect) throws Exception {
        if ((have == null && have != expect) || (have != null && !have.equals(expect))) {
            String msg = "TEST " + testid + ": HAVE \"" + have + "\" EXPECT \"" + expect + "\"";
            System.out.println("StringConversion: " + msg);
            throw new Exception(msg);
        }
        return have;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3115().check(testid, have, expect);
    }
}
